package com.sorting;

import java.util.Arrays;

/**
 * Created by Dhaval on 6/19/2016.
 */
public class ShellSort {

    public static void sort(Comparable[] a){

        int N = a.length;
        int h = 1;

        while(h < N/3) h = 3*h + 1;

        while(h >= 1){
            //h-sort the array

            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(a[j], a[j-h]); j -= h){
                    exch(a, j, j - h);
                }
            }

            h = h/3;
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
