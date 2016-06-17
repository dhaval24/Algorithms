package com.dynamic.connectivity;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Dhaval on 6/11/2016.
 */
public class TestClient {

    public static void main(String[] args) {

        int N = StdIn.readInt();
        //QuickFind quickFind = new QuickFind(N);
        //QuickUnion quickUnion = new QuickUnion(N);
        //WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(N);
        PCWeightedQuickUnion pcWeightedQuickUnion = new PCWeightedQuickUnion(N);
        while(!StdIn.isEmpty()){

            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(!pcWeightedQuickUnion.isConnected(p, q)){

                pcWeightedQuickUnion.union(p, q);
                StdOut.println(p + "  " + q); // Union performed

            }
        }
    }
}
