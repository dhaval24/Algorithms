package com.sorting;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by Dhaval on 10/13/2016.
 * This algorithm is used to find the Kth largest element in the
 * list and the same algorithm can be modified to find kth smallest. We just need to supply
 * because it essentially means (n-k)th largest element
 *
 *
 * This algorithm makes use of the partition function from quicksort and repeatedly partitions the
 * array until the partition index is the kth index and we stop here. The right of the array would
 * be k largest elements in the array.
 */
public class QuickSelect {

    public Comparable findKLargest(Comparable[] a, int k) {

        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j > k) hi = j - 1;
            else if (j < k) lo = j + 1;
            else return a[k];
        }
        System.out.println(Arrays.toString(a));
        return a[k];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo]))
                if (i == hi) break;

            while (less(a[lo], a[--j]))
                if (j == lo) break;

            if (i >= j) break;
            exchange(a, i, j);
        }

        exchange(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        System.out.println(new QuickSelect().findKLargest(new Integer[]{10, 7, 11, 2 , 16, 8, 0}, 3));
    }

}
