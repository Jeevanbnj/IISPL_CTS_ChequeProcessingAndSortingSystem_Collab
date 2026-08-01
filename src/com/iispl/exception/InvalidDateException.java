package com.iispl.exception;

public class InvalidDateException extends Exception {

	public InvalidDateException() {
		super("Date can not be null or empty");
	}

	
}
