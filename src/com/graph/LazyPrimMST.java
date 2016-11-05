package com.graph;

import edu.princeton.cs.algs4.MinPQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 11/5/2016.
 */
public class LazyPrimMST {

    private boolean[] marked; //boolean array to keep track of vertices which have been already added to MST
    private Queue<Edge> mst;
    private MinPQ<Edge> pq; // Min Priority queue to find the minimum edge which has atleast one element in the tree

    public LazyPrimMST(EdgeWeightedGraph G) {

        pq = new MinPQ<>();
        mst = new LinkedList<>();
        marked = new boolean[G.V()];
        visit(G, 0); // visit vertex 0 and add all the edges from 0 in pq

        while(!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w]) continue; //both vertices in mst
            if(!marked[v]) visit(G, v); //visit the vertex and explore its edges which is not in MST
            if(!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true; // mark the vertex as visited
        for (Edge e : G.adj(v)) {  // explore all the edges from v and add those edge in pq whose other vertex then v is not marked already
            if(!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> mst() {
        return mst;
    }
}
