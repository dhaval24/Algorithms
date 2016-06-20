package com.sorting;

/**
 * Created by Dhaval on 6/19/2016.
 */
public class SelectionSort {

    /**
     * quadratic algorithm to perform sorting
     * Finds min from i - length and swaps the min with a[i]
     * @param Array of type comparable
     */
    public static void sort(Comparable[] a) {

        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min); //exchange min with current a[i], 0 - i elements sorted
        }
    }

    /**
     * Returns if v is small or greater to w
     * @param v
     * @param w
     * @return boolean value
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * swaps 2 value
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {

        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;

    }
}
