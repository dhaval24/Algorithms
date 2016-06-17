package com.threesum;

import edu.princeton.cs.algs4.In;

/**
 * Created by Dhaval on 6/12/2016.
 */
public class ThreeSumTester {

    public static void main(String[] args) {

        int[] a =   In.readInts("data\\ThreeSumpInput1");
        System.out.println(ThreeSumDelux.count(a));
    }
}
