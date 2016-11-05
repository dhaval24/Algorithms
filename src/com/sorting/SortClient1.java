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
        Double[] b = new Double[N];
        Double[] c = new Double[N];
        for (int i = 0; i < N; i++) {
            double temp = StdRandom.uniform();
            a[i] = temp;
            b[i] = temp;
            c[i] = temp;
        }
        Long start = System.currentTimeMillis();
        //SelectionSort.sort(a);
        //InsertionSort.sort(a);
        //ShellSort.sort(a);
        RecurrsiveMergeSort.sort(a);
        Long end = System.currentTimeMillis();
        System.out.println("Time taken to sort array of" + args[0] + " entries " + (end - start));
        //System.out.println(Arrays.toString(a));

        start = System.currentTimeMillis();
        ThreeWayQuickSort.sort(b);
        end = System.currentTimeMillis();
        System.out.println("Time taken to sort array of" + args[0] + " entries " + (end - start));

        start = System.currentTimeMillis();
        HeapSort.sort(c);
        end = System.currentTimeMillis();
        System.out.println("Time taken to sort array of" + args[0] + " entries " + (end - start));

        System.out.println(Arrays.toString(c));

    }
}
