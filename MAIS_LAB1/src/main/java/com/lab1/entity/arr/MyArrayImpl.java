package com.lab1.entity.arr;

import java.util.Arrays;

import org.apache.logging.log4j.*;

public class MyArrayImpl extends MyArray {

	private static final Logger logger = LogManager.getLogger(MyArrayImpl.class);

	public MyArrayImpl() {
		array = new int[0];
		this.size = 0;
	}

	public MyArrayImpl(int arraySize) {
		array = new int[arraySize];
		this.size = arraySize;
	}

	@Override
	public void add(int value) {
		int[] newArray = new int[size + 1];
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		newArray[size] = value;
		array = newArray;
		size++;
	}

	@Override
	public void remove(int index) {
		// int removedValue = array[index];

		int newSize = size - 1;
		int[] newArray = new int[newSize];
		for (int i = 0; i < index; i++) {
			newArray[i] = array[i];
		}
		for (int i = index + 1; i < newSize; i++) {
			newArray[i] = array[i];
		}
	}

	public MyArray copyArray() {
		MyArray newArray = new MyArrayImpl(size);
		// int[] copyOfArray = new int[size];
		for (int i = 0; i < size; i++) {
			newArray.set(i, array[i]);
		}
		return newArray;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		MyArray comparableArray = (MyArray) object;
		if (this.size != comparableArray.size)
			return false;
		for (int i = 0, n = this.size; i < n; i++) {
			if (array[i] != comparableArray.get(i))
				return false;
		}
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return " \n  " + Arrays.toString(array) + ", " + "size of this array= " + size
				+ "\n_________________________";
	}

}
