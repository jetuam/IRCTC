package com.irctc.operations.dto;

import java.time.LocalDate;

import java.util.List;
import com.irctc.operations.dto.PassengerDto;

public class BookRequestDTO {

	String userId;
	String trainId;
	LocalDate date;
	int noOfTickets;
	List<PassengerDto> passengerDto;
	
	public List<PassengerDto> getPassengerDto() {
		return passengerDto;
	}

	public void setPassengerDto(List<PassengerDto> passengerDto) {
		this.passengerDto = passengerDto;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

}
