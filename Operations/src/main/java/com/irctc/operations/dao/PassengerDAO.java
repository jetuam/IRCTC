package com.irctc.operations.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.operations.model.Passenger;

@Repository
public interface PassengerDAO extends CrudRepository<Passenger, String> {

}
