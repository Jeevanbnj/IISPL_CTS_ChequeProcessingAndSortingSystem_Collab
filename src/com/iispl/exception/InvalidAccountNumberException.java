package com.iispl.exception;

public class InvalidAccountNumberException extends Exception {

	public InvalidAccountNumberException() {
		super("Account number can not be null or empty");
	}
}
