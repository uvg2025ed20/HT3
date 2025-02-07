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

public class App {
    public static void main(String[] args) {
        // Generar y guardar 4000 números aleatorios de 4 dígitos en un CSV
        generateAndSaveRandomNumbersToCSV("./src/main/java/com/uvg/numeros.csv", 15000);

        // Cargar los números desde el CSV
        Integer[] numbers = loadNumbersFromCSV("./src/main/java/com/uvg/numeros.csv");

        // Crear un comparador para comparar enteros
        IComparator<Integer> comparator = new IComparator<Integer>() {
            @Override
            public int Compare(Integer _object1, Integer _object2) {
                return _object1.compareTo(_object2);
            }
        };

        // Crear un objeto Sort con el comparador
        Sort<Integer> sorter = new Sort<>(comparator);

        // Medir el tiempo de ejecución para cada algoritmo

        // Insertion Sort
        Integer[] numbersForInsertionSort = Arrays.copyOf(numbers, numbers.length);
        long startTime = System.nanoTime();
        sorter.insertionSort(numbersForInsertionSort);
        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución de Insertion Sort: " + (endTime - startTime) + " nanosegundos");

        // Merge Sort
        Integer[] numbersForMergeSort = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        sorter.mergeSort(numbersForMergeSort);
        endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución de Merge Sort: " + (endTime - startTime) + " nanosegundos");

        // Quick Sort
        Integer[] numbersForQuickSort = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        sorter.quickSort(numbersForQuickSort, 0, numbersForQuickSort.length - 1);
        endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución de Quick Sort: " + (endTime - startTime) + " nanosegundos");

        // Heap Sort
        Integer[] numbersForHeapSort = Arrays.copyOf(numbers, numbers.length);
        startTime = System.nanoTime();
        sorter.heapSort(numbersForHeapSort);
        endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución de Heap Sort: " + (endTime - startTime) + " nanosegundos");

        // Radix Sort
        int[] intNumbers = Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();
        startTime = System.nanoTime();
        sorter.radixSort(intNumbers);
        endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución de Radix Sort: " + (endTime - startTime) + " nanosegundos");

        // Bucket Sort
        int[] intNumbersBucket = Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();
        startTime = System.nanoTime();
        sorter.bucketSort(intNumbersBucket);
        endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución de Bucket Sort: " + (endTime - startTime) + " nanosegundos");
    }

    // Método para generar números aleatorios y guardarlos en un archivo CSV
    private static void generateAndSaveRandomNumbersToCSV(String filename, int count) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < count; i++) {
                int number = 1000 + random.nextInt(9000); // Generar un número de 4 dígitos
                writer.write(number + (i < count - 1 ? "," : ""));
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para cargar números desde un archivo CSV en un arreglo de Integer
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
                        System.err.println("Número inválido: " + numStr);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return numberList.toArray(new Integer[0]);
    }
}
