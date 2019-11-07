package com.example.Authentication.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Authentication.dto.BookRequestDTO;
import com.example.Authentication.dto.BookingHistoryDTO;
import com.example.Authentication.dto.MealBookingDto;

@RestController
public class BookingController {

	@Autowired
	RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@PostMapping("/tickets")
	public List<String> bookTickets(@RequestBody BookRequestDTO bookRequestDto) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BookRequestDTO> entity = new HttpEntity<>(bookRequestDto, headers);

		return restTemplate.exchange("http://OPERATIONS/book/ticket", HttpMethod.POST, entity, List.class).getBody();
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/users/{userId}/tickets")
	public List<BookingHistoryDTO> getBookingHistory(@PathVariable String userId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange("http://OPERATIONS/book/history/" + userId, HttpMethod.GET, entity, List.class).getBody();
	}

	@GetMapping(value = "/tickets/{pnrNumber}")
	public String cancelTicket(@PathVariable String pnrNumber) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange("http://OPERATIONS/book/cancel/" + pnrNumber, HttpMethod.GET, entity, String.class)
				.getBody();
	}

	@PostMapping("/meal-bookings")
	public Float bookMeal(@RequestBody MealBookingDto mealBookingDto) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<MealBookingDto> entity = new HttpEntity<>(mealBookingDto, headers);

		return restTemplate.exchange("http://OPERATIONS/book/meal", HttpMethod.POST, entity, Float.class).getBody();
	}
}
