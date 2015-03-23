package com.sampleproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

public class MergeQuickSortGenerics {
    
    private final static Random rand = new Random();
    
    static <T> void mergeSort(final T[] a, final Comparator<T> c) {
        if (a.length <= 1) {
            return;
        }
        final T[] a0 = Arrays.copyOfRange(a, 0, a.length / 2);
        final T[] a1 = Arrays.copyOfRange(a, a.length / 2, a.length);
        mergeSort(a0, c);
        mergeSort(a1, c);
        merge(a0, a1, a, c);
    }

    static <T> void merge(final T[] a0, final T[] a1, final T[] a,
            final Comparator<T> c) {
        int i0 = 0;
        int i1 = 0;
        for (int i = 0; i < a.length; i++) {
            if (i0 == a0.length) {
                a[i] = a1[i1++];
            } else if (i1 == a1.length) {
                a[i] = a0[i0++];
            } else if (c.compare(a0[i0], a1[i1]) < 0) {
                a[i] = a0[i0++];
            } else {
                a[i] = a1[i1++];
            }
        }
    }

    static <T> void swap(final T[] a, final int i, final int j) {
        final T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static <T> void quickSort(final T[] a, final Comparator<T> c) {
        quickSort(a, 0, a.length, c);
    }

    static <T> void quickSort(final T[] a, final int i, final int n,
            final Comparator<T> c) {
        if (n <= 1) {
            return;
        }
        final T x = a[i + rand.nextInt(n)];
        int p = i - 1, j = i, q = i + n;
        // a[i..p]<x, a[p+1..q-1]??x, a[q..i+n-1]>x
        while (j < q) {
            final int comp = c.compare(a[j], x);
            if (comp < 0) { // move to beginning of array

                swap(a, j++, ++p);
            } else if (comp > 0) {
                swap(a, j, --q); // move to end of array
            } else {
                j++; // keep in the middle
            }
        }
        // a[i..p]<x, a[p+1..q-1]=x, a[q..i+n-1]>x
        quickSort(a, i, p - i + 1, c);
        quickSort(a, q, n - (q - i), c);
    }

    /**
     * 
     * @param array
     */
    private static <T> void printArray(final T[] array) {
        for (final T line : array) {
            System.out.print(line.toString() + " ");
        }
    }
    
    public static int randInt(final int min, final int max) {

        // Usually this can be a field rather than a method variable
        final Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        final int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    private static final int FIXED_SIZE = 100000;
    
    /**
     * @param args
     */
    public static void main(final String[] args) {
        final Integer[] list = new Integer[FIXED_SIZE];
        for (int x=0; x < FIXED_SIZE; x++) {
            list[x] = randInt(1, 100000);
        }
        
        System.out.println("<<< MergeSort - Before >>>");
        //printArray(list);
        CompareClass<Integer> compare = new CompareClass<Integer>();
        long start = System.nanoTime();
        mergeSort(list, compare);
        double diff = (System.nanoTime() - start) / 1e6;
        System.out.println("\n\n<<< MergeSort - After >>>" + diff);
        //printArray(list);

        // Quick Sort
        final Integer[] list2 = new Integer[FIXED_SIZE];
        for (int x=0; x < FIXED_SIZE; x++) {
            list2[x] = randInt(1, 100000);
        }
        System.out.println("\n\n<<< QuickSort - Before >>>");
        //printArray(list2);
        compare = new CompareClass<Integer>();
        start = System.nanoTime();
        quickSort(list2, compare);
        diff = (System.nanoTime() - start) / 1e6;
        System.out.println("\n\n<<< QuickSort - After >>>" + diff);
        //printArray(list2);
    }
}
