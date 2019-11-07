package com.example.Authentication.exception;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {

	LocalDate date;
	String url;
	String message;

	public ErrorMessage() {

	}

	public ErrorMessage(LocalDate date, String url, String message) {
		super();
		this.date = date;
		this.url = url;
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
