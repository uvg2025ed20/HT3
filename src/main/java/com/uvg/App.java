package com.uvg;

import com.uvg.controllers.IComparator;
import com.uvg.controllers.Sort;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[3000];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }

        System.out.println(" ** Arreglo original **");
        printArray(numbers);

        IComparator<Integer> comparator = new IComparator<Integer>() {
            @Override
            public int Compare(Integer _object1, Integer _object2) {
                return _object1.compareTo(_object2);
            }
        };

        Sort<Integer> sorter = new Sort<>(comparator);

        sorter.insertionSort(numbers);
        System.out.println(" ** Arreglo ordenado con Insertion Sort **");
        System.out.println(Arrays.toString(numbers));

        sorter.myCompare = comparator;
        sorter.mergeSort(numbers);
        System.out.println(" ** Arreglo ordenado con Merge Sort **");
        System.out.println(Arrays.toString(numbers));

        sorter.myCompare = comparator;
        sorter.quickSort(numbers, 0, numbers.length - 1);
        System.out.println(" ** Arreglo ordenado con Quick Sort **");
        System.out.println(Arrays.toString(numbers));

        sorter.myCompare = comparator;
        sorter.heapSort(numbers);
        System.out.println(" ** Arreglo ordenado con Heap Sort **");
        System.out.println(Arrays.toString(numbers));
    }

    private static void printArray(Integer[] arr) {
        for (int i = 0; i < Math.min(arr.length, 20); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("...");
    }
}
