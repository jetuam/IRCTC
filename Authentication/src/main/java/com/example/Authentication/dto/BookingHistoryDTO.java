package com.example.Authentication.dto;

import java.time.LocalDate;

public class BookingHistoryDTO {

	LocalDate date;
	int noOfTickets;
	String trainId;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

}
