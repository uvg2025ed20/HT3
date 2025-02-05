package com.uvg;

        import com.uvg.controllers.IComparator;
        import com.uvg.controllers.Sort;
        import java.util.Random;
        import java.util.Arrays;
        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

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
                Integer[] numbers = loadNumbersFromCSV("./src/main/java/com/uvg/numeros.csv");
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

                int[] intNumbers = Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();

                sorter.myCompare = comparator;
                sorter.radixSort(intNumbers);
                System.out.println(" ** Arreglo ordenado con Radix Sort **");
                System.out.println(Arrays.toString(numbers));

                int[] intNumbersBucket = Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();

                sorter.myCompare = comparator;
                sorter.bucketSort(intNumbersBucket);
                System.out.println(" ** Arreglo ordenado con Bucket Sort **");
                System.out.println(Arrays.toString(numbers));

            }

            /**
             * Prints the first 20 elements of the given array.
             *
             * @param arr The array to be printed.
             */
            /**
             * Loads numbers from a CSV file into an Integer array.
             *
             * @param filename The name of the CSV file.
             * @return An Integer array containing the numbers from the file.
             */
            private static Integer[] loadNumbersFromCSV(String filename) {
                List<Integer> numberList = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] numbers = line.split(",");
                        for (String numStr : numbers) {
                            try {
                                numberList.add(Integer.parseInt(numStr.trim()));
                            } catch (NumberFormatException e) {
                                System.err.println("Invalid number: " + numStr);
                            }
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error reading the file: " + e.getMessage());
                }


                return numberList.toArray(new Integer[0]);
            }
        }