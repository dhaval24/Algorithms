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

    public int V() {
        return V;
    }

    private int E() {
        int count = 0;
        for (int i = 0; i < V(); i++) {
            count += adj[i].size();
        }
        return count/2;
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int w) {
        return adj[w];
    }
}
