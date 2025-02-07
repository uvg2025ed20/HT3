package com.uvg.controllers;

        import java.util.Arrays;
        import java.util.ArrayList;
        import java.util.Collections;

        /**
         * The Sort class provides various sorting algorithms that can be used
         * to sort arrays of generic type T.
         * @author Angel Sanabria
         * @author Pablo Vasquez
         * @param <T> The type of elements to be sorted.
         */
        public class Sort<T> {
            /**
             * Comparator used to compare elements of type T.
             */
            public IComparator<T> myCompare;

            /**
             * Constructs a Sort object with the specified comparator.
             *
             * @param _Compare The comparator to be used for sorting.
             */
            public Sort(IComparator<T> _Compare) {
                myCompare = _Compare;
            }

            /**
             * Sorts the specified array using the Insertion Sort algorithm.
             *
             * @param arr The array to be sorted.
             */
            public void insertionSort(T[] arr) {
                int n = arr.length;
                for (int i = 1; i < n; i++) {
                    T key = arr[i];
                    int j = i - 1;
                    while (j >= 0 && myCompare.Compare(arr[j], key) > 0) {
                        arr[j + 1] = arr[j];
                        j = j - 1;
                    }
                    arr[j + 1] = key;
                }
            }

            /**
             * Sorts the specified array using the Merge Sort algorithm.
             *
             * @param arr The array to be sorted.
             */
            public void mergeSort(T[] arr) {
                if (arr.length < 2) return;
                int mid = arr.length / 2;
                T[] left = Arrays.copyOfRange(arr, 0, mid);
                T[] right = Arrays.copyOfRange(arr, mid, arr.length);

                mergeSort(left);
                mergeSort(right);
                merge(arr, left, right);
            }

            /**
             * Merges two sorted arrays into a single sorted array.
             *
             * @param arr The array to hold the merged result.
             * @param left The left sub-array.
             * @param right The right sub-array.
             */
            public void merge(T[] arr, T[] left, T[] right) {
                int i = 0, j = 0, k = 0;
                while (i < left.length && j < right.length) {
                    if (myCompare.Compare(left[i], right[j]) <= 0) {
                        arr[k++] = left[i++];
                    } else {
                        arr[k++] = right[j++];
                    }
                }
                while (i < left.length) {
                    arr[k++] = left[i++];
                }
                while (j < right.length) {
                    arr[k++] = right[j++];
                }
            }

            /**
             * Sorts the specified array using the Quick Sort algorithm.
             *
             * @param arr The array to be sorted.
             * @param low The starting index.
             * @param high The ending index.
             */
            public void quickSort(T[] arr, int low, int high) {
                if (low < high) {
                    int pi = partition(arr, low, high);
                    quickSort(arr, low, pi - 1);
                    quickSort(arr, pi + 1, high);
                }
            }

            /**
             * Partitions the array for Quick Sort.
             *
             * @param arr The array to be partitioned.
             * @param low The starting index.
             * @param high The ending index.
             * @return The partition index.
             */
            public int partition(T[] arr, int low, int high) {
                T pivot = arr[high];
                int i = (low - 1);
                for (int j = low; j < high; j++) {
                    if (myCompare.Compare(arr[j], pivot) < 0) {
                        i++;
                        T temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
                T temp = arr[i + 1];
                arr[i + 1] = arr[high];
                arr[high] = temp;
                return i + 1;
            }

            /**
             * Sorts the specified array of integers using the Radix Sort algorithm.
             *
             * @param arr The array to be sorted.
             */
            public void radixSort(int[] arr) {
                int max = findMax(arr);
                for (int exp = 1; max / exp > 0; exp *= 10) {
                    countingSortByDigit(arr, exp);
                }
            }

            /**
             * Finds the maximum value in the array.
             *
             * @param arr The array to be searched.
             * @return The maximum value.
             */
            public int findMax(int[] arr) {
                int max = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
                return max;
            }

            /**
             * Performs counting sort on the array based on the specified digit.
             *
             * @param arr The array to be sorted.
             * @param exp The digit position to be considered.
             */
            public void countingSortByDigit(int[] arr, int exp) {
                int n = arr.length;
                int[] output = new int[n];
                int[] count = new int[10];

                for (int i = 0; i < n; i++) {
                    count[(arr[i] / exp) % 10]++;
                }

                for (int i = 1; i < 10; i++) {
                    count[i] += count[i - 1];
                }

                for (int i = n - 1; i >= 0; i--) {
                    output[count[(arr[i] / exp) % 10] - 1] = arr[i];
                    count[(arr[i] / exp) % 10]--;
                }

                System.arraycopy(output, 0, arr, 0, n);
            }

            /**
             * Sorts the specified array of floats using the Bucket Sort algorithm.
             *
             * @param arr The array to be sorted.
             */
            public void bucketSort(int[] arr) {
                int n = arr.length;
                if (n <= 0) return;

                // Encuentra el valor máximo en el array para normalizar los valores
                int maxValue = findMax(arr);

                // Crea los buckets
                ArrayList<Integer>[] buckets = new ArrayList[n];
                for (int i = 0; i < n; i++) {
                    buckets[i] = new ArrayList<>();
                }

                // Distribuye los elementos en los buckets
                for (int num : arr) {
                    int index = (int) ((double) num / (maxValue + 1) * n);
                    buckets[index].add(num);
                }

                // Ordena cada bucket y combina los resultados
                int index = 0;
                for (ArrayList<Integer> bucket : buckets) {
                    Collections.sort(bucket);
                    for (int num : bucket) {
                        arr[index++] = num;
                    }
                }
            }
            /**
             * Sorts the specified array using the Heap Sort algorithm.
             *
             * @param arr The array to be sorted.
             */
            public void heapSort(T[] arr) {
                int n = arr.length;
                for (int i = n / 2 - 1; i >= 0; i--) {
                    heapify(arr, n, i);
                }
                for (int i = n - 1; i > 0; i--) {
                    T temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;
                    heapify(arr, i, 0);
                }
            }

            /**
             * Heapifies a subtree rooted with node i which is an index in arr[].
             *
             * @param arr The array to be heapified.
             * @param n The size of the heap.
             * @param i The root index of the subtree.
             */
            public void heapify(T[] arr, int n, int i) {
                int largest = i;
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                if (left < n && myCompare.Compare(arr[left], arr[largest]) > 0) largest = left;
                if (right < n && myCompare.Compare(arr[right], arr[largest]) > 0) largest = right;
                if (largest != i) {
                    T temp = arr[i];
                    arr[i] = arr[largest];
                    arr[largest] = temp;
                    heapify(arr, n, largest);
                }
            }
        }