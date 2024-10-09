package com.lab1;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lab1.entity.arr.MyArrayImpl;
import com.lab1.entity.arr.MyArray;
import com.lab1.services.MyArraySortService;

public class ArraySortServiceTest {

	MyArray unsortedArray;
	MyArray acsSortedArray;
	MyArray descSortedArray;

	@BeforeTest
	public void initArrays() {
		unsortedArray = new MyArrayImpl();
		unsortedArray.add(3);
		unsortedArray.add(1);
		unsortedArray.add(6);
		unsortedArray.add(2);
		unsortedArray.add(-1);

		acsSortedArray = new MyArrayImpl();
		acsSortedArray.add(-1);
		acsSortedArray.add(1);
		acsSortedArray.add(2);
		acsSortedArray.add(3);
		acsSortedArray.add(6);

		descSortedArray = new MyArrayImpl();
		descSortedArray.add(6);
		descSortedArray.add(3);
		descSortedArray.add(2);
		descSortedArray.add(1);
		descSortedArray.add(-1);
	}

	@Test
	public void ascendingExchangeSortTest() {
		Assert.assertEquals(MyArraySortService.exchangeSort(unsortedArray, true), acsSortedArray);
	}

	@Test
	public void descendingExchangeSortTest() {
		Assert.assertEquals(MyArraySortService.exchangeSort(unsortedArray, false), descSortedArray);
	}

	@Test
	public void ascendingInsertionSortTest() {
		Assert.assertEquals(MyArraySortService.insertionSort(unsortedArray, true), acsSortedArray);
	}

	@Test
	public void descendingInsertionSortTest() {
		Assert.assertEquals(MyArraySortService.insertionSort(unsortedArray, false), descSortedArray);
	}

	@Test
	public void ascendingSelectionSortTest() {
		Assert.assertEquals(MyArraySortService.selectionSort(unsortedArray, true), acsSortedArray);
	}

	@Test
	public void descendingSelectionSortTest() {
		Assert.assertEquals(MyArraySortService.selectionSort(unsortedArray, false), descSortedArray);
	}
}
