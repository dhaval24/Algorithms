package com.sorting;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Dhaval on 6/19/2016.
 */
public class DeckShuffle {

    public static void shuffle(Object[] a){

        int N = a.length;
        for(int i = 0; i < N; i++) {

            int r = StdRandom.uniform(i+1);
            exch(a, i, r);
        }
    }

    /**
     * swaps 2 value
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Object[] a, int i, int j) {

        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;

    }
}
