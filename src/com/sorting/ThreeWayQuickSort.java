package com.sorting;

import edu.princeton.cs.algs4.Insertion;

/**
 * Created by Dhaval on 10/14/2016.
 * This is the most optimal quick sort algorithm specially in case array has
 * many duplicate values
 * We accumulate all the duplicate values between lt and gt pointers and then the task is to only sort the
 * left and right halves which dont have duplicates
 */
public class ThreeWayQuickSort {

    private static final int CUTTOFF = 7;

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo + CUTTOFF -1 ) {
            Insertion.sort(a, lo, hi);
            return;
        }

        if(hi <= lo) return;
        int lt = lo;
        int gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exchange(a, lt++, i++);
            else if (cmp > 0) exchange(a, i, gt--); //i is not incremented as after swapping value is changed and is not compared yet
            else i++;
        }

        sort(a, lo, lt - 1); //sort left half
        sort(a, gt + 1, hi); //sort right half
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
