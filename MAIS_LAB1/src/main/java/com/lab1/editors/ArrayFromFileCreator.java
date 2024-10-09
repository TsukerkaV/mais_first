package com.lab1.editors;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lab1.entity.arr.MyArrayImpl;
import com.lab1.entity.arr.MyArray;
import com.lab1.exceptions.BadInputLineException;
import com.lab1.exceptions.ThereIsNoSuchFileInInputDirectoryException;

public class ArrayFromFileCreator implements Closeable {

	private static final Logger logger = LogManager.getLogger(ArrayFromFileCreator.class);

	private static final String VALUES_DELIMETER = "\\s+";

	private final Path INPUT_FILES_LOCATION = Paths
			.get("/Users/verailukevic/Desktop/Раф/МАИС/MAIS_LAB1/src/main/resources/inputFiles/");
	private final Path INPUT_FILE_PATH;
	private BufferedReader fileReader;

	public ArrayFromFileCreator(String fileName)
			throws FileNotFoundException, ThereIsNoSuchFileInInputDirectoryException {

		INPUT_FILE_PATH = Paths.get(INPUT_FILES_LOCATION.toString(), fileName);

		if (!INPUT_FILE_PATH.toFile().exists())
			throw new ThereIsNoSuchFileInInputDirectoryException(
					"In input files directory there is no " + fileName + " file");

		fileReader = new BufferedReader(new FileReader(INPUT_FILE_PATH.toFile()));
	}

	public MyArray nextArray() throws IOException, BadInputLineException {

		if (fileReader.ready()) {
			String inputLine = fileReader.readLine();
			if (ArrayInputValidator.isLineOK(inputLine)) {

				MyArray newArray = new MyArrayImpl();
				for (String part : inputLine.split(VALUES_DELIMETER)) {
					newArray.add(Integer.parseInt(part));
				}
				return newArray;
			} else {
				logger.error("\nBad input. MyArray is not created"); // &
				throw new BadInputLineException("Input line \"" + inputLine + "\" doesn't match given pattern.");
			}
		} else {
			return null;
		}
	}

	public boolean ready() throws IOException {

		return fileReader.ready();
	}

	@Override
	public void close() throws IOException {

		fileReader.close();
	}
}
