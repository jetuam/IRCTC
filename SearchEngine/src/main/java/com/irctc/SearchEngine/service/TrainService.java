package com.irctc.SearchEngine.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.SearchEngine.dao.TrainDAO;

import com.irctc.SearchEngine.dto.TrainDisplayDTO;
import com.irctc.SearchEngine.dto.TrainResponseDTO;
import com.irctc.SearchEngine.dto.TrainSeatUpdateDto;
import com.irctc.SearchEngine.exception.TrainNotFoundException;
import com.irctc.SearchEngine.model.Train;

@Service
public class TrainService {

	@Autowired
	TrainDAO traindao;
	
	final String constantValue="Not Found";

	public String addTrainDetails(Train train) {
		String message = "Successfully added!";
		traindao.save(train);
		return message;
	}

	public TrainResponseDTO searchTrainByPlace(String fromPlace, String toPlace, String date) {

		ModelMapper modelMapper = new ModelMapper();
		Train train = traindao.findByPlaceAndDate(fromPlace, toPlace, date);
		if (train == null) {
			throw new TrainNotFoundException(
					"Train from " + fromPlace + " to " + toPlace + " on " + date + " " + " isn't available!");
		}
	
		return modelMapper.map(train, TrainResponseDTO.class);
	}

	public TrainDisplayDTO searchTrainById(String trainId, String date) {
		ModelMapper modelMapper = new ModelMapper();
		Train train = traindao.findByTrainId(trainId, date);
		if (train == null) {
			throw new TrainNotFoundException(trainId + ", " + date + " " +constantValue);
		}
		return modelMapper.map(train, TrainDisplayDTO.class);
	}

	public int seatAvailibility(String trainId) {
		Train train = traindao.findByTrainid(trainId);
		if (train == null) {
			throw new TrainNotFoundException(trainId + " " +constantValue);
		}

		return train.getNumberOfSeats();
	}

	public void updateNumberOfSeats(String trainId, TrainSeatUpdateDto trainSeatUpdateDto) {

		Train train = traindao.findByTrainid(trainId);
		if (train == null) {
			throw new TrainNotFoundException(trainId + " " +constantValue);
		}

		train.setNumberOfSeats(trainSeatUpdateDto.getNoOfSeats());
		traindao.save(train);
	}

}
