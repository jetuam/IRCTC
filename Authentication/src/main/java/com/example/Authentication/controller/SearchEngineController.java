package com.example.Authentication.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Authentication.dto.FoodMenuDTO;
import com.example.Authentication.dto.FoodResponseDTO;
import com.example.Authentication.dto.TrainDTO;
import com.example.Authentication.dto.TrainDisplayDTO;
import com.example.Authentication.dto.TrainResponseDTO;

@RestController
public class SearchEngineController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/trains/{trainId}")
	public TrainDisplayDTO getTrainById(@PathVariable String trainId, @RequestParam(value = "date") String date) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange("http://SEARCHENGINE/trainbyId/" + trainId + "/?date=" + date, HttpMethod.GET,
				entity, TrainDisplayDTO.class).getBody();
	}

	@GetMapping(value = "/trains")
	public TrainResponseDTO getTrainByPlace(@RequestParam(value = "fromPlace") String fromPlace,
			@RequestParam(value = "toPlace") String toPlace, @RequestParam(value = "date") String date) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange(
				"http://SEARCHENGINE/trainbyPlace?fromPlace=" + fromPlace + "&toPlace=" + toPlace + "&date=" + date,
				HttpMethod.GET, entity, TrainResponseDTO.class).getBody();
	}

	@GetMapping(value = "/trains/seats/{trainId}")
	public Integer seatAvailibility(@PathVariable String trainId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate
				.exchange("http://SEARCHENGINE/trains/seatAvailable/" + trainId, HttpMethod.GET, entity, Integer.class)
				.getBody();
	}

	@PostMapping("/add/trains")
	public String addTrain(@RequestBody TrainDTO trainDTO) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<TrainDTO> entity = new HttpEntity<>(trainDTO, headers);

		return restTemplate.exchange("http://SEARCHENGINE/train/add", HttpMethod.POST, entity, String.class).getBody();
	}

	@GetMapping(value = "/meals")
	public FoodResponseDTO searchFood(@RequestParam(value = "trainId") String trainId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange("http://SEARCHENGINE/foodmenu/search?trainId=" + trainId, HttpMethod.GET, entity,
				FoodResponseDTO.class).getBody();
	}

	@PostMapping("/add/food")
	public String addFood(@RequestBody FoodMenuDTO foodmenuDTO) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<FoodMenuDTO> entity = new HttpEntity<>(foodmenuDTO, headers);

		return restTemplate.exchange("http://SEARCHENGINE/foodmenu/add", HttpMethod.POST, entity, String.class)
				.getBody();
	}

}
