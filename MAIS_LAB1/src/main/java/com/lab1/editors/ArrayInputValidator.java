package com.lab1.editors;

public class ArrayInputValidator {
	private static final String OK_INPUT_LINE_REGEX = "[0-9\\s\\-]+";

	public static boolean isLineOK(String inputLine){
		return inputLine.matches(OK_INPUT_LINE_REGEX);
	}
}
