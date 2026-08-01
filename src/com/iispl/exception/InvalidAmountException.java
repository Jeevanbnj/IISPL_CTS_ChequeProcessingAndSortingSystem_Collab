package com.iispl.exception;

public class InvalidAmountException extends Exception {

	public InvalidAmountException() {
		super("Amount should be greater than zero");
	}

}
