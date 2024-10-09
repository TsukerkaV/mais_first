package com.lab1.exceptions;

public class OutOfBoundException extends RuntimeException{
	
	public OutOfBoundException(String errorMessage){
		super(errorMessage);
	}
}
