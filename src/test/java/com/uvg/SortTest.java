package com.uvg;
import com.uvg.controllers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

/**
 * Test class for Sort.
 */
public class SortTest {

    private Sort<Integer> sortInt;
    private Sort<String> sortString;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /**
     * Sets up the test environment before each test.
     * Initializes Sort objects for Integer and String types.
     */
    @BeforeEach
    void setUp() {
        // Integer comparator
        IComparator<Integer> intComparator = Integer::compareTo;

        // String comparator
        IComparator<String> stringComparator = String::compareTo;

        sortInt = new Sort<>(intComparator);
        sortString = new Sort<>(stringComparator);
    }

    /**
     * Tests the insertionSort method for sorting an array of integers.
     */
    @Test
    void testInsertionSort() {
        Integer[] arr = {5, 3, 8, 4, 2};
        Integer[] expected = {2, 3, 4, 5, 8};

        sortInt.insertionSort(arr);

        assertArrayEquals(expected, arr);
    }

    /**
     * Tests the mergeSort method for sorting an array of integers.
     */
    @Test
    void testMergeSort() {
        Integer[] arr = {9, 7, 5, 3, 1};
        Integer[] expected = {1, 3, 5, 7, 9};

        sortInt.mergeSort(arr);

        assertArrayEquals(expected, arr);
    }

    /**
     * Tests the quickSort method for sorting an array of integers.
     */
    @Test
    void testQuickSort() {
        Integer[] arr = {10, 80, 30, 90, 40, 50, 70};
        Integer[] expected = {10, 30, 40, 50, 70, 80, 90};

        sortInt.quickSort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr);
    }

    /**
     * Tests the radixSort method for sorting an array of integers.
     */
    @Test
    void testRadixSort() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};

        sortInt.radixSort(arr);

        assertArrayEquals(expected, arr);
    }

    /**
     * Tests the bucketSort method for sorting an array of floats.
     */
    @Test
    void testBucketSort() {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f};
        float[] expected = {0.23f, 0.25f, 0.32f, 0.42f, 0.52f};

        sortInt.bucketSort(arr);

        assertArrayEquals(expected, arr, 0.0001f);
    }

    /**
     * Tests the heapSort method for sorting an array of integers.
     */
    @Test
    void testHeapSort() {
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        Integer[] expected = {5, 6, 7, 11, 12, 13};

        sortInt.heapSort(arr);

        assertArrayEquals(expected, arr);
    }

    /**
     * Tests the insertionSort method for sorting an array of strings.
     */
    @Test
    void testStringSort() {
        String[] arr = {"banana", "apple", "orange", "grape"};
        String[] expected = {"apple", "banana", "grape", "orange"};

        sortString.insertionSort(arr);

        assertArrayEquals(expected, arr);
    }
}