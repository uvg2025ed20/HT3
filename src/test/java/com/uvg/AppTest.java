package com.uvg;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
/**
 * This class contains test cases for different sorting algorithm implementations.
 * The algorithms tested include InsertionSort, MergeSort, QuickSort, HeapSort, RadixSort, and BucketSort.
 *
 * @author Angel Sanabria
 * @author Pablo Vasquez
 */
public class AppTest {

    /**
     * Integer comparator that implements the IComparator interface.
     */
    private final IComparator<Integer> intComparator = new IComparator<Integer>() {
        @Override
        public int Compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };

    /**
     * Float comparator that implements the IComparator interface.
     */
    private final IComparator<Float> floatComparator = new IComparator<Float>() {
        @Override
        public int Compare(Float o1, Float o2) {
            return o1.compareTo(o2);
        }
    };

    /**
     * Unit test for the Insertion Sort algorithm.
     * Verifies that the array is correctly sorted with the algorithm.
     */
    @Test
    public void testInsertionSort() {
        Integer[] arr = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        Sort<Integer> sorter = new Sort<>(intComparator);
        sorter.insertionSort(arr);
        System.out.println("InsertionSort Result: " + Arrays.toString(arr));
        assertArrayEquals(expected, arr, "The array was not sorted correctly with Insertion Sort.");
    }

    /**
     * Unit test for the Merge Sort algorithm.
     * Verifies that the array is correctly sorted with the algorithm.
     */
    @Test
    public void testMergeSort() {
        Integer[] arr = {10, 3, 15, 7, 8, 23, 74, 18};
        Integer[] expected = {3, 7, 8, 10, 15, 18, 23, 74};
        Sort<Integer> sorter = new Sort<>(intComparator);
        sorter.mergeSort(arr);
        System.out.println("MergeSort Result: " + Arrays.toString(arr));
        assertArrayEquals(expected, arr, "The array was not sorted correctly with Merge Sort.");
    }

    /**
     * Unit test for the Quick Sort algorithm.
     * Verifies that the array is correctly sorted with the algorithm.
     */
    @Test
    public void testQuickSort() {
        Integer[] arr = {22, 11, 99, 88, 9, 7, 42};
        Integer[] expected = {7, 9, 11, 22, 42, 88, 99};
        Sort<Integer> sorter = new Sort<>(intComparator);
        sorter.quickSort(arr, 0, arr.length - 1);
        System.out.println("QuickSort Result: " + Arrays.toString(arr));
        assertArrayEquals(expected, arr, "The array was not sorted correctly with Quick Sort.");
    }

    /**
     * Unit test for the Heap Sort algorithm.
     * Verifies that the array is correctly sorted with the algorithm.
     */
    @Test
    public void testHeapSort() {
        Integer[] arr = {4, 10, 3, 5, 1};
        Integer[] expected = {1, 3, 4, 5, 10};
        Sort<Integer> sorter = new Sort<>(intComparator);
        sorter.heapSort(arr);
        System.out.println("HeapSort Result: " + Arrays.toString(arr));
        assertArrayEquals(expected, arr, "The array was not sorted correctly with Heap Sort.");
    }

    /**
     * Unit test for the Radix Sort algorithm.
     * Verifies that the array is correctly sorted with the algorithm.
     */
    @Test
    public void testRadixSort() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        // An object of Sort with Integer is used, although the radixSort method operates on int[]
        Sort<Integer> sorter = new Sort<>(intComparator);
        sorter.radixSort(arr);
        System.out.println("RadixSort Result: " + Arrays.toString(arr));
        assertArrayEquals(expected, arr, "The array was not sorted correctly with Radix Sort.");
    }

    /**
     * Unit test for the Bucket Sort algorithm.
     * Verifies that the array of floats is correctly sorted with the algorithm.
     */
    @Test
    public void testBucketSort() {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        float[] expected = {0.1234f, 0.3434f, 0.565f, 0.656f, 0.665f, 0.897f};
        Sort<Float> sorter = new Sort<>(floatComparator);
        sorter.bucketSort(arr);
        System.out.println("BucketSort Result: " + Arrays.toString(arr));
        assertArrayEquals(expected, arr, 0.0001f, "The array was not sorted correctly with Bucket Sort.");
    }
}
