package com.lab1.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lab1.entity.arr.MyArray;

public class MyArraySortService {

	private static final Logger logger = LogManager.getLogger(MyArraySortService.class);

	// Метод сортировки обменом
	public static MyArray exchangeSort(MyArray array, boolean ascendingOrder) {
		MyArray sortedArray = array.copyArray();
		int temp;
		if (ascendingOrder) {
			for (int i = 0, n = sortedArray.size(); i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (sortedArray.get(i) > sortedArray.get(j)) {
						temp = sortedArray.get(i);
						sortedArray.set(i, sortedArray.get(j));
						sortedArray.set(j, temp);
					}
				}
			}
		} else {
			for (int i = 0, n = sortedArray.size(); i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (sortedArray.get(i) < sortedArray.get(j)) {
						temp = sortedArray.get(i);
						sortedArray.set(i, sortedArray.get(j));
						sortedArray.set(j, temp);
					}
				}
			}
		}
		return sortedArray;
	}

	// Метод сортировки вставками
	public static MyArray insertionSort(MyArray array, boolean ascendingOrder) {
		MyArray sortedArray = array.copyArray();
		int temp;
		if (ascendingOrder) {
			for (int i = 1, n = sortedArray.size(); i < n; i++) {
				temp = sortedArray.get(i);
				int j = i - 1;
				while (j >= 0 && sortedArray.get(j) > temp) {
					sortedArray.set(j + 1, sortedArray.get(j));
					j--;
				}
				sortedArray.set(j + 1, temp);
			}
		} else {
			for (int i = 1, n = sortedArray.size(); i < n; i++) {
				temp = sortedArray.get(i);
				int j = i - 1;
				while (j >= 0 && sortedArray.get(j) < temp) {
					sortedArray.set(j + 1, sortedArray.get(j));
					j--;
				}
				sortedArray.set(j + 1, temp);
			}
		}
		return sortedArray;
	}

	// Метод сортировки выбором (заменяет быструю сортировку)
	public static MyArray selectionSort(MyArray array, boolean ascendingOrder) {
		MyArray sortedArray = array.copyArray();
		if (ascendingOrder) {
			for (int i = 0, n = sortedArray.size(); i < n - 1; i++) {
				int minIndex = i;
				for (int j = i + 1; j < n; j++) {
					if (sortedArray.get(j) < sortedArray.get(minIndex)) {
						minIndex = j;
					}
				}
				int temp = sortedArray.get(minIndex);
				sortedArray.set(minIndex, sortedArray.get(i));
				sortedArray.set(i, temp);
			}
		} else {
			for (int i = 0, n = sortedArray.size(); i < n - 1; i++) {
				int maxIndex = i;
				for (int j = i + 1; j < n; j++) {
					if (sortedArray.get(j) > sortedArray.get(maxIndex)) {
						maxIndex = j;
					}
				}
				int temp = sortedArray.get(maxIndex);
				sortedArray.set(maxIndex, sortedArray.get(i));
				sortedArray.set(i, temp);
			}
		}
		return sortedArray;
	}
}
