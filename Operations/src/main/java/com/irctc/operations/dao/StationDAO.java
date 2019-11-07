package com.irctc.operations.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.operations.model.Station;

@Repository
public interface StationDAO extends CrudRepository<Station, String> {

}
