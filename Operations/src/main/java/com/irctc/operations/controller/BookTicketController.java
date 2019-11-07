package com.irctc.operations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.operations.dto.BookRequestDTO;
import com.irctc.operations.dto.BookingHistoryDTO;
import com.irctc.operations.dto.MealBookingDto;
import com.irctc.operations.service.BookTicketService;

@RestController
public class BookTicketController {

	@Autowired
	BookTicketService bookTicketService;

	@PostMapping("/book/ticket")
	public List<String> bookTicket(@RequestBody BookRequestDTO bookRequestDto) {
		return bookTicketService.bookTicket(bookRequestDto);
	}

	@GetMapping("/book/history/{userId}")
	public List<BookingHistoryDTO> bookHistory(@PathVariable String userId) {
		return bookTicketService.bookHistory(userId);
	}

	@GetMapping("/book/cancel/{pnrNumber}")
	public String cancelTicket(@PathVariable String pnrNumber) {
		bookTicketService.cancelTicket(pnrNumber);
		return "Successfully Cancelled";
	}

	@PostMapping("/book/meal")
	public float bookMeal(@RequestBody MealBookingDto mealBookingDto) {
		return bookTicketService.bookMeal(mealBookingDto);

	}

}
