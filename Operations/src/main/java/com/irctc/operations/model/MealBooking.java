package com.irctc.operations.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MealBooking {

	@Id
	String pnrNumber;
	String meal;
	float cost;

	public String getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

}
