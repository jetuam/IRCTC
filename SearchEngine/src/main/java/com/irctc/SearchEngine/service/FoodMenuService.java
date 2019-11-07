package com.irctc.SearchEngine.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.SearchEngine.dao.FoodMenuDAO;
import com.irctc.SearchEngine.dto.FoodResponseDTO;

import com.irctc.SearchEngine.exception.FoodNotFoundException;
import com.irctc.SearchEngine.model.FoodMenu;

@Service
public class FoodMenuService {

	@Autowired
	FoodMenuDAO foodmenudao;

	public String addFoodDetails(FoodMenu foodmenu) {

		String message = "Successfully added";
		foodmenudao.save(foodmenu);
		return message;
	}

	public FoodResponseDTO searchFoodMenu(String trainId) {

		Optional<FoodMenu> foodMenu = foodmenudao.findById(trainId);
	
			if (foodMenu.isPresent() && foodMenu.get().getMeal1() == null && foodMenu.get().getMeal2() == null
					&& foodMenu.get().getMeal3() == null) {
				throw new FoodNotFoundException(
						"Food service currently unavailable for this particular Train" + trainId);
			
		}
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(foodMenu, FoodResponseDTO.class);

	}

}
