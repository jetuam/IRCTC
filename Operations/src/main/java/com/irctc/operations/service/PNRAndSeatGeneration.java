package com.irctc.operations.service;

import java.util.ArrayList;
import java.util.List;

public class PNRAndSeatGeneration {

	
	
	int seatNumber = 101;

	public List<String> generatePNR(String trainId, int numberOfSeats) {
		List<String> pnrList = new ArrayList<>();
		String pnr;
		for (int i = 0; i < numberOfSeats; i++) {
			pnr = trainId + "GN" + seatNumber++;
			pnrList.add(pnr);
		}

		return pnrList;
	}

}
