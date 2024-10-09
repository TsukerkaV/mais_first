package com.lab1.exceptions;

import java.io.FileNotFoundException;

public class ThereIsNoSuchFileInInputDirectoryException extends FileNotFoundException{
	
	public ThereIsNoSuchFileInInputDirectoryException(String message){
		super(message);
	}
}
