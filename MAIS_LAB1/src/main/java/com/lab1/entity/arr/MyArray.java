package com.lab1.entity.arr;

import com.lab1.exceptions.OutOfBoundException;

public abstract class MyArray {

	protected int[] array;
	protected int size;

	public MyArray() {
		array = new int[0];
		size = 0;
	}

	public int get(int index) {
		validateIndex(index);
		return array[index];
	}

	public void set(int index, int value) {
		validateIndex(index);
		array[index] = value;
	}

	public abstract void add(int value);

	public abstract void remove(int index);

	public abstract MyArray copyArray();

	public int size() {
		return size;
	}

	protected void validateIndex(int index) {
		if (index < 0 || index >= size) {
			throw new OutOfBoundException("Index out of bounds: " + index);
		}
	}
}
