package com.iispl.exception;

public class InvalidDrawerNameException extends Exception {

	public InvalidDrawerNameException() {
		super("Drawer name can not be null or empty");
	}

	
}
