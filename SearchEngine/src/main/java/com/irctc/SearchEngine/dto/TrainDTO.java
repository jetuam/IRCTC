package com.irctc.SearchEngine.dto;

import java.time.LocalTime;

import com.irctc.SearchEngine.model.TrainKey;

public class TrainDTO {

	TrainKey trainKey;
	String trainName;
	String fromPlace;
	String toPlace;
	LocalTime arrivalTime;
	LocalTime departureTime;
	int numberOfSeats;
	float seatPrice;

	public TrainKey getTrainKey() {
		return trainKey;
	}

	public void setTrainKey(TrainKey trainKey) {
		this.trainKey = trainKey;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public float getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(float seatPrice) {
		this.seatPrice = seatPrice;
	}

}
