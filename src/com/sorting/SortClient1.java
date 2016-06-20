package com.sorting;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by Dhaval on 6/19/2016.
 */
public class SortClient1 {

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        Long start = System.currentTimeMillis();
        SelectionSort.sort(a);
        Long end = System.currentTimeMillis();
        System.out.println("Time taken to sort array of" + args[0] + " entries " + (end - start));
        System.out.println(Arrays.toString(a));
    }
}
