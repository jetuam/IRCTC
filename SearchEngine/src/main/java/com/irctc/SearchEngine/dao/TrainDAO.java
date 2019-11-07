package com.irctc.SearchEngine.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.SearchEngine.model.Train;
import com.irctc.SearchEngine.model.TrainKey;

@Repository
public interface TrainDAO extends CrudRepository<Train, TrainKey> {

	@Query(value = "select * from train where from_place=?1 AND to_place=?2 AND date=?3", nativeQuery = true)
	Train findByPlaceAndDate(String fromPlace, String toPlace, String date);

	@Query(value = "select * from train where train_id=?1 AND date=?2", nativeQuery = true)
	Train findByTrainId(String trainId, String date);

	@Query(value = "select * from train where train_id=?1", nativeQuery = true)
	Train findByTrainid(String trainId);
}
