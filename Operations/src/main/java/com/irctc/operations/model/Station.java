package com.irctc.operations.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {

	@Id
	String trainId;
	String stationName;
	int platformNumber;

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getPlatformNumber() {
		return platformNumber;
	}

	public void setPlatformNumber(int platformNumber) {
		this.platformNumber = platformNumber;
	}

}
