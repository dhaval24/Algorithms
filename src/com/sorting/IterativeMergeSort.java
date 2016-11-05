package com.sorting;

/**
 * Created by Dhaval on 10/13/2016.
 */
public class IterativeMergeSort {

    private static Comparable[] aux;

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

    public static void sort(Comparable[] A) {

        int n = A.length;
        aux = new Comparable[n];

        for (int sz = 1; sz < n; sz += sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(A, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
            }
        }
    }

}
