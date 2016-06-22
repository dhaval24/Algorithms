package com.sorting;

/**
 * Quadratic time algorithm
 * All the elements to the left of a[j] are sorted in its own
 * Created by Dhaval on 6/19/2016.
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {

        int N = a.length;
        for(int i = 0; i < N; i++){

            for(int j = i; j > 0; j--) {

                if(less(a[j], a[j-1])){ // put a[j] to its correct position
                    exch(a, i, j);
                }
                else{
                    break;
                }
            }
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
