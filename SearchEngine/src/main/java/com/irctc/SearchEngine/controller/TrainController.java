package com.irctc.SearchEngine.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.irctc.SearchEngine.dto.TrainDTO;
import com.irctc.SearchEngine.dto.TrainDisplayDTO;
import com.irctc.SearchEngine.dto.TrainResponseDTO;
import com.irctc.SearchEngine.dto.TrainSeatUpdateDto;
import com.irctc.SearchEngine.model.Train;
import com.irctc.SearchEngine.service.TrainService;

@RestController
public class TrainController {

	@Autowired
	TrainService trainservice;

	@PostMapping("/train/add")
	public String addTrainDetails(@RequestBody TrainDTO trainDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Train train = modelMapper.map(trainDTO, Train.class);
		return trainservice.addTrainDetails(train);

	}

	@PatchMapping("/train/update/{trainId}")
	public String updateNumberOfSeats(@PathVariable String trainId, @RequestBody TrainSeatUpdateDto numberOfSeats) {
		trainservice.updateNumberOfSeats(trainId, numberOfSeats);
		return "Successfully updated";

	}

	@GetMapping("/trainbyId/{trainId}")
	public TrainDisplayDTO searchTrainByTrainId(@PathVariable String trainId,
			@RequestParam(value = "date") String date) {
		return trainservice.searchTrainById(trainId, date);
	}

	@GetMapping("/trainbyPlace")
	public TrainResponseDTO searchTrainByReqParam(@RequestParam(value = "fromPlace") String fromPlace,
			@RequestParam(value = "toPlace") String toPlace, @RequestParam(value = "date") String date) {
		return trainservice.searchTrainByPlace(fromPlace, toPlace, date);
	}

	@GetMapping("/trains/seatAvailable/{trainId}")
	public int seatAvailibility(@PathVariable String trainId) {
		return trainservice.seatAvailibility(trainId);
	}

}
