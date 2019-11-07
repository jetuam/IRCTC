package com.irctc.SearchEngine.dto;

import java.time.LocalTime;

public class TrainDisplayDTO {

	String trainName;
	LocalTime arrivalTime;
	LocalTime departureTime;
	int numberOfSeats;
	float seatPrice;
	String fromPlace;
	String toPlace;

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

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
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
