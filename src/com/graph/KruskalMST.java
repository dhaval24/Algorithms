package com.graph;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 11/5/2016.
 * Algorithm: 1. Sort the edges in the ascending order (Use Min Priority Queue)
 * 2. Add edges in the tree in order if on adding an edge cycle is not formed. (Check using Union Find)
 *
 * Worst Case Complexity : O(E Log E)
 */
public class KruskalMST {

    private Queue<Edge> mst = new LinkedList<>();

    public KruskalMST(EdgeWeightedGraph G) {
        MinPQ<Edge> pq = new MinPQ<>(); // get edges in order of minimum weight, we could have used array and sorted it also but this is elegant
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        UF uf = new UF(G.V()); // This data structure is used to check if the cycle is formed in O(log*V) time
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
