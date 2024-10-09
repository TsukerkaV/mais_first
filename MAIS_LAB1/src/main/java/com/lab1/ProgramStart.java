package com.lab1;

import com.lab1.exceptions.BadInputLineException;
import com.lab1.exceptions.ThereIsNoSuchFileInInputDirectoryException;
import com.lab1.services.MyArraySortService;
import com.lab1.editors.ArrayFromFileCreator;
import com.lab1.entity.arr.MyArray;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProgramStart {

    private static final Logger logger = LogManager.getLogger(ProgramStart.class);

    public static void main(String[] args) {
        logger.info("\nProgram has started"); // Лог начала программы

        try (ArrayFromFileCreator arrayCreator = new ArrayFromFileCreator("input1.txt")) {
            while (arrayCreator.ready()) {
                try {
                    // Получаем массив
                    MyArray array = arrayCreator.nextArray();
                    System.out.println("Array: " + array);

                } catch (BadInputLineException e) {
                    System.out.println("\nInvalid input: " + e.getMessage());
                    continue; // Пропуск некорректной строки и продолжение цикла
                }
            }

        } catch (ThereIsNoSuchFileInInputDirectoryException e) {
            logger.error("\nFailed to read input file: " + e.getMessage());
            System.out.println("\nFailed to read input file: " + e.getMessage());
        } catch (IOException e) {
            logger.error("\nThere are problems with IO");
            e.printStackTrace();
        }

        try (ArrayFromFileCreator arrayCreator = new ArrayFromFileCreator("arrayForSort.txt")) {
            while (arrayCreator.ready()) {
                try {
                    // Получаем массив
                    MyArray array = arrayCreator.nextArray();
                    System.out.println("Original array: " + array);

                    // Вызов сортировки обменом
                    MyArray exchangeSortedArrayAsc = MyArraySortService.exchangeSort(array, true);
                    System.out.println("Exchange sorted (ascending): " + exchangeSortedArrayAsc);

                    // Вызов сортировки вставками
                    MyArray insertionSortedArrayAsc = MyArraySortService.insertionSort(array, true);
                    System.out.println("Insertion sorted (ascending): " + insertionSortedArrayAsc);

                    // Вызов сортировки выбором
                    MyArray selectionSortedArrayAsc = MyArraySortService.selectionSort(array, true);
                    System.out.println("Selection sorted (ascending): " + selectionSortedArrayAsc);

                } catch (BadInputLineException e) {
                    System.out.println("\nInvalid input: " + e.getMessage());
                    continue; // Пропуск некорректной строки и продолжение цикла
                }
            }

        } catch (ThereIsNoSuchFileInInputDirectoryException e) {
            logger.error("\nFailed to read input file: " + e.getMessage());
            System.out.println("\nFailed to read input file: " + e.getMessage());
        } catch (IOException e) {
            logger.error("\nThere are problems with IO");
            e.printStackTrace();
        }

        logger.info("\nProgram has ended"); // Лог завершения программы
    }
}
