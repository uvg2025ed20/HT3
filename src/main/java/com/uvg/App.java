package com.uvg;

        import com.uvg.controllers.IComparator;
        import com.uvg.controllers.Sort;
        import java.util.Random;
        import java.util.Arrays;

        /**
         * The App class demonstrates the usage of various sorting algorithms
         * (Insertion Sort, Merge Sort, Quick Sort, and Heap Sort) on an array
         * of random integers.
         */
        public class App {
            /**
             * The main method is the entry point of the application.
             * It generates an array of random integers, sorts it using different
             * sorting algorithms, and prints the results.
             *
             * @param args Command line arguments (not used).
             */
            public static void main(String[] args) {
                // Create an array of 3000 random integers
                Integer[] numbers = new Integer[3000];
                Random random = new Random();
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = random.nextInt(10000);
                }

                // Create a comparator for comparing integers
                IComparator<Integer> comparator = new IComparator<Integer>() {
                    @Override
                    public int Compare(Integer _object1, Integer _object2) {
                        return _object1.compareTo(_object2);
                    }
                };

                // Create a Sort object with the comparator
                Sort<Integer> sorter = new Sort<>(comparator);

                // Sort the array using Insertion Sort and print the result
                sorter.insertionSort(numbers);
                System.out.println(" ** Arreglo ordenado con Insertion Sort **");
                System.out.println(Arrays.toString(numbers));

                // Sort the array using Merge Sort and print the result
                sorter.myCompare = comparator;
                sorter.mergeSort(numbers);
                System.out.println(" ** Arreglo ordenado con Merge Sort **");
                System.out.println(Arrays.toString(numbers));

                // Sort the array using Quick Sort and print the result
                sorter.myCompare = comparator;
                sorter.quickSort(numbers, 0, numbers.length - 1);
                System.out.println(" ** Arreglo ordenado con Quick Sort **");
                System.out.println(Arrays.toString(numbers));

                // Sort the array using Heap Sort and print the result
                sorter.myCompare = comparator;
                sorter.heapSort(numbers);
                System.out.println(" ** Arreglo ordenado con Heap Sort **");
                System.out.println(Arrays.toString(numbers));
            }

            /**
             * Prints the first 20 elements of the given array.
             *
             * @param arr The array to be printed.
             */
            private static void printArray(Integer[] arr) {
                for (int i = 0; i < Math.min(arr.length, 20); i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println("...");
            }
        }