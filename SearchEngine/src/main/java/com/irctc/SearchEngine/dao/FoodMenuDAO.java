package com.irctc.SearchEngine.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.SearchEngine.model.FoodMenu;

@Repository
public interface FoodMenuDAO extends CrudRepository<FoodMenu, String> {

}
