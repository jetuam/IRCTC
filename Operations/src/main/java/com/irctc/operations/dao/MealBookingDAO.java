package com.irctc.operations.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.operations.model.MealBooking;

@Repository
public interface MealBookingDAO extends CrudRepository<MealBooking, String> {

}
