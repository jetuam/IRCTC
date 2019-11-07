package com.irctc.operations.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.irctc.operations.dao.BookTicketDAO;
import com.irctc.operations.dao.MealBookingDAO;
import com.irctc.operations.dao.PassengerDAO;
import com.irctc.operations.dao.StationDAO;
import com.irctc.operations.dto.BookRequestDTO;
import com.irctc.operations.dto.BookingHistoryDTO;
import com.irctc.operations.dto.FoodResponseDTO;
import com.irctc.operations.dto.MealBookingDto;
import com.irctc.operations.dto.TrainDisplayDTO;
import com.irctc.operations.dto.TrainSeatUpdateDto;
import com.irctc.operations.model.BookTicket;
import com.irctc.operations.model.MealBooking;
import com.irctc.operations.model.Passenger;
import com.irctc.operations.model.Station;

@Service
public class BookTicketService {

	@Autowired
	BookTicketDAO bookTicketDao;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	StationDAO stationDao;

	@Autowired
	PassengerDAO passengerDao;

	@Autowired
	MealBookingDAO mealBookingDAO;

	ModelMapper mapper = new ModelMapper();

	public List<String> bookTicket(BookRequestDTO bookRequestDto) {

		TrainDisplayDTO trainList = restTemplate.getForObject(
				"http://SEARCHENGINE/trainbyId/" + bookRequestDto.getTrainId() + "/?date=" + bookRequestDto.getDate(),
				TrainDisplayDTO.class);

		BookTicket bookTicket1 = new BookTicket();
		bookTicket1 = mapper.map(trainList, BookTicket.class);

		Optional<Station> station = stationDao.findById(bookRequestDto.getTrainId());
		if (station.isPresent()) {
			bookTicket1.setPlatformNumber(station.get().getPlatformNumber());
		}
		bookTicket1.setNoOfTickets(bookRequestDto.getNoOfTickets());
		bookTicket1.setTrainId(bookRequestDto.getTrainId());
		bookTicket1.setUserId(bookRequestDto.getUserId());
		BookingIdGeneration bookingID = new BookingIdGeneration();
		String bookId = bookingID.generateBookId();
		bookTicket1.setBookingId(bookId);
		bookTicket1.setDate(bookRequestDto.getDate());
		bookTicketDao.save(bookTicket1);

		PNRAndSeatGeneration pnrAndSeatGeneration = new PNRAndSeatGeneration();

		Passenger passenger1 = new Passenger();
		List<String> pnrList = pnrAndSeatGeneration.generatePNR(bookRequestDto.getTrainId(),
				bookRequestDto.getNoOfTickets());
		pnrList.add(bookId);

		String seatNumber;
		for (int i = 0; i < bookRequestDto.getNoOfTickets(); i++) {
			passenger1.setPnrNumber(pnrList.get(i));
			seatNumber = pnrList.get(i).substring(5, 10);
			passenger1.setSeatNumber(seatNumber);
			passenger1.setPassengerName(bookRequestDto.getPassengerDto().get(i).getPassengerName());
			passenger1.setPassengerEmail(bookRequestDto.getPassengerDto().get(i).getPassengerEmail());
			passenger1.setBookingId(bookTicket1.getBookingId());
			passengerDao.save(passenger1);
		}
		bookTicketDao.save(bookTicket1);

		TrainSeatUpdateDto trainSeatUpdateDto = new TrainSeatUpdateDto();

		trainSeatUpdateDto.setNoOfSeats(trainList.getNumberOfSeats() - bookRequestDto.getNoOfTickets());
		restTemplate.patchForObject("http://SEARCHENGINE/train/update/" + bookRequestDto.getTrainId(),
				trainSeatUpdateDto, String.class);
		return pnrList;

	}

	@SuppressWarnings("unchecked")
	public List<BookingHistoryDTO> bookHistory(String userId) {

		List<BookTicket> bookticket = bookTicketDao.findByUserId(userId);
		return mapper.map(bookticket, List.class);

	}

	public void cancelTicket(String pnrNumber) {

		Optional<Passenger> passenger = passengerDao.findById(pnrNumber);
		if (passenger.isPresent()) {
			String bookingId = passenger.get().getBookingId();

			String trainId = pnrNumber.substring(0, 5);
			int numberOfSeats = restTemplate.getForObject("http://SEARCHENGINE/trains/seatAvailable/" + trainId,
					Integer.class);

			TrainSeatUpdateDto trainSeatUpdateDto = new TrainSeatUpdateDto();

			trainSeatUpdateDto.setNoOfSeats(numberOfSeats + 1);
			restTemplate.patchForObject("http://SEARCHENGINE/train/update/" + trainId, trainSeatUpdateDto,
					String.class);

			Optional<BookTicket> bookticket = bookTicketDao.findById(bookingId);
			if(bookticket.isPresent()) {
			bookticket.get().setNoOfTickets(bookticket.get().getNoOfTickets() - 1);
			if (bookticket.get().getNoOfTickets() != 0) {

				bookTicketDao.save(bookticket.get());
			} else {
				bookTicketDao.deleteById(bookingId);
			}

			passengerDao.deleteById(pnrNumber);
			}
		}
	}

	public float bookMeal(MealBookingDto mealBookingDto) {

		MealBooking mealBooking = mapper.map(mealBookingDto, MealBooking.class);
		String trainId = mealBooking.getPnrNumber().substring(0, 5);
		FoodResponseDTO foodResponseDTO = restTemplate
				.getForObject("http://SEARCHENGINE/foodmenu/search?trainId=" + trainId, FoodResponseDTO.class);
		mealBooking.setCost(foodResponseDTO.getFoodPrice());
		mealBookingDAO.save(mealBooking);
		return mealBooking.getCost();

	}

}
