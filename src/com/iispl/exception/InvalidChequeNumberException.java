package com.iispl.exception;

public class InvalidChequeNumberException extends Exception {

	public InvalidChequeNumberException() {
		super("ChequeNumber can not be null or empty");
	}

	
}
