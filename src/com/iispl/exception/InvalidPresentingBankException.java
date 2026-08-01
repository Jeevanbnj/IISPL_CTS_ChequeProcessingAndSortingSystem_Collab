package com.iispl.exception;

public class InvalidPresentingBankException extends Exception {

	public InvalidPresentingBankException() {
		super("Presenting bank can not be null or empty");
	}

	
}
