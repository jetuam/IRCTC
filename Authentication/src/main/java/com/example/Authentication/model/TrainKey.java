package com.example.Authentication.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class TrainKey implements Serializable {

	String trainId;
	LocalDate date;

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
