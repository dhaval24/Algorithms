package com.sorting;

import edu.princeton.cs.algs4.Insertion;

/**
 * Created by Dhaval on 10/13/2016.
 */
public class RecurrsiveMergeSort {


    private static final int CUTTOFF = 7;

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {

            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) {
                a[k] = a[j++];
            }
            else {
                a[k] = a[i++];
            }
        }

    }

    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int high) {

        if (high <= lo + CUTTOFF - 1) {
            Insertion.sort(a, lo, high); // If size of array is less than 7 switch to insertion sort
        }

        if (high <= lo) return;
        int mid = lo + (high - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, high);
        if (!less(a[mid+1], a[mid])) return; // If array is sorted return
        merge(a, aux, lo, mid, high);

    }

    public static void sort(Comparable[] a) {

        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
