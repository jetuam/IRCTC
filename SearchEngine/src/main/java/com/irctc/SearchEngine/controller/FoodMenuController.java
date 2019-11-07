package com.irctc.SearchEngine.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.SearchEngine.dto.FoodMenuDTO;
import com.irctc.SearchEngine.dto.FoodResponseDTO;
import com.irctc.SearchEngine.model.FoodMenu;
import com.irctc.SearchEngine.service.FoodMenuService;

@RestController
public class FoodMenuController {

	@Autowired
	FoodMenuService foodmenuservice;

	@PostMapping("/foodmenu/add")
	public String addFoodDetails(@RequestBody FoodMenuDTO foodmenuDTO) {

		ModelMapper modelMapper = new ModelMapper();
		FoodMenu foodmenu = modelMapper.map(foodmenuDTO, FoodMenu.class);
		return foodmenuservice.addFoodDetails(foodmenu);

	}

	@GetMapping("/foodmenu/search")
	public FoodResponseDTO searchFoodMenu(@RequestParam(value = "trainId") String trainId) {
		return foodmenuservice.searchFoodMenu(trainId);
	}

}
