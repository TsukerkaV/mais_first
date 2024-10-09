package com.lab1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lab1.entity.arr.MyArray;
import com.lab1.entity.arr.MyArrayImpl;
import com.lab1.exceptions.OutOfBoundException;

public class ArrayImplTest {

	@Test(priority = 1, enabled = true)
	public void getTest() {
		MyArray array = new MyArrayImpl(3);
		array.set(0, 2);
		array.set(1, 4);
		array.set(2, 8);

		Assert.assertEquals(array.get(0), 2);
		Assert.assertEquals(array.get(1), 4);
		Assert.assertEquals(array.get(2), 8);
	}

	@Test(expectedExceptions = OutOfBoundException.class)
	public void getOutOfBoundExceptionTest() {
		MyArray array = new MyArrayImpl(3);
		array.get(3);
	}

	@Test
	public void addElementTest() {
		MyArray array = new MyArrayImpl();
		array.add(10);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(array.size(), 1);
		softAssert.assertEquals(array.get(0), 10);
		softAssert.assertAll();
	}

	@Test
	public void sizeTest() {
		MyArray array = new MyArrayImpl(3);
		Assert.assertEquals(array.size(), 3);
	}

	@Test
	public void copyArrayTest() {
		MyArray array = new MyArrayImpl();
		array.add(1);
		array.add(2);
		array.add(3);
		MyArray copiedArray = array.copyArray();
		Assert.assertEquals(array, copiedArray);
	}
	// @Test
	// public void removeElementAtValidIndex() {
	// MyArray myArray = new MyArrayImpl();
	// myArray.add(10);
	// myArray.add(20);
	// myArray.add(30);
	// myArray.add(40);
	// myArray.add(50);

	// // Удаляем элемент по индексу 2 (30)
	// int removedValue = myArray.remove(2);
	// Assert.assertEquals(removedValue, 30, "Удаленное значение должно быть 30.");

	// // Проверяем, что размер массива уменьшился на 1
	// Assert.assertEquals(myArray.size(), 4, "Размер массива должен быть 4 после
	// удаления.");

	// // Проверяем правильность оставшихся элементов
	// Assert.assertEquals(myArray.get(0), 10, "Первый элемент должен быть 10.");
	// Assert.assertEquals(myArray.get(1), 20, "Второй элемент должен быть 20.");
	// Assert.assertEquals(myArray.get(2), 40, "Третий элемент должен быть 40.");
	// Assert.assertEquals(myArray.get(3), 50, "Четвертый элемент должен быть 50.");
	// }

	@Test(expectedExceptions = OutOfBoundException.class)
	public void removeElementAtInvalidIndex() {
		MyArray myArray = new MyArrayImpl();
		myArray.add(10);
		myArray.add(20);
		myArray.add(30);

		// Пытаемся удалить элемент по некорректному индексу (например, 10)
		myArray.remove(2);
	}

	@Test(expectedExceptions = OutOfBoundException.class)
	public void removeElementAtNegativeIndex() {
		MyArray myArray = new MyArrayImpl();
		myArray.add(10);
		myArray.add(20);
		myArray.add(30);

		// Пытаемся удалить элемент по негативному индексу (-1)
		myArray.remove(-1);
	}

}
