package com.sampleproblems;

public class QuickSort {

    public static void main(final String[] args) {
        final int[] x = { 9, 2, 4, 7, 3, 7, 10 };
        System.out.println("<<< Before >>>");
        printArray(x);

        sort(x);
        System.out.println("\n\n<<< After >>>");
        printArray(x);
    }

    private static void printArray(final int[] x) {
        for (final int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void quickSort(final int[] arr, final int low, final int high) {

        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        // pick the pivot
        final int middle = low + (high - low) / 2;
        final int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                final int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    public static void sort(final int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        final int low = 0;
        final int high = values.length - 1;

        quickSort(values, low, high);
    }

}
