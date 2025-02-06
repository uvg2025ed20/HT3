package com.uvg;

                import com.uvg.controllers.IComparator;
                import com.uvg.controllers.Sort;
                import java.util.Random;
                import java.util.Arrays;
                import java.io.BufferedReader;
                import java.io.FileReader;
                import java.io.FileWriter;
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
                        // Generate and save 300,000 random 4-digit numbers to CSV
                        generateAndSaveRandomNumbersToCSV("./src/main/java/com/uvg/numeros.csv", 300000);

                        // Load numbers from CSV
                        Integer[] numbers = loadNumbersFromCSV("./src/main/java/com/uvg/numeros.csv");

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
                        //sorter.insertionSort(numbers);

                        // Sort the array using Merge Sort and print the result
                        sorter.myCompare = comparator;
                        sorter.mergeSort(numbers);

                        // Sort the array using Quick Sort and print the result
                        sorter.myCompare = comparator;
                        sorter.quickSort(numbers, 0, numbers.length - 1);

                        // Sort the array using Heap Sort and print the result
                        sorter.myCompare = comparator;
                        sorter.heapSort(numbers);

                        int[] intNumbers = Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();

                        sorter.myCompare = comparator;
                        sorter.radixSort(intNumbers);

                        int[] intNumbersBucket = Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();

                        sorter.myCompare = comparator;
                        sorter.bucketSort(intNumbersBucket);
                    }

                    /**
                     * Generates a list of random 4-digit numbers and saves them to a CSV file.
                     *
                     * @param filename The name of the CSV file.
                     * @param count The number of random numbers to generate.
                     */
                    private static void generateAndSaveRandomNumbersToCSV(String filename, int count) {
                        Random random = new Random();
                        try (FileWriter writer = new FileWriter(filename)) {
                            for (int i = 0; i < count; i++) {
                                int number = 1000 + random.nextInt(9000); // Generate a 4-digit number
                                writer.write(number + (i < count - 1 ? "," : ""));
                            }
                        } catch (IOException e) {
                            System.err.println("Error writing to the file: " + e.getMessage());
                        }
                    }

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