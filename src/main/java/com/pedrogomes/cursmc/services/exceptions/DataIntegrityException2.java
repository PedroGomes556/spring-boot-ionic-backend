package com.pedrogomes.cursmc.services.exceptions;

public class DataIntegrityException2 extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException2(String msg) {
		super(msg);
	}
	
	public DataIntegrityException2(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
