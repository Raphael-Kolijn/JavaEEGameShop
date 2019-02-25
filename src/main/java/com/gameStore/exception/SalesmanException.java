package com.gameStore.exception;

public class SalesmanException extends Exception {

	public SalesmanException(String message) {
		super(message);
	}

	public SalesmanException(String message, Exception e) {
		super(message, e);
	}
}