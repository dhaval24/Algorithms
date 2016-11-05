package com.graph;

import edu.princeton.cs.algs4.Bag;

/**
 * Created by Dhaval on 11/3/2016.
 */
public class Digraph {

    private final int V;
    private final Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int w) {
        return adj[w];
    }
}
