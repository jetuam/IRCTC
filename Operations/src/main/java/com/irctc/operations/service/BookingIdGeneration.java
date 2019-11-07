package com.irctc.operations.service;

public class BookingIdGeneration {

	public String generateBookId() {
		
		
		int bookingCount = (int) (Math.random()*Math.pow(10, 3));
		return "BID" + bookingCount;
	}

}
