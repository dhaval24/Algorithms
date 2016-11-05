package com.graph;

import edu.princeton.cs.algs4.Bag;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dhaval on 11/4/2016.
 */
public class EdgeWeightedGraph {

    private final int V;
    private final Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public int V() {
        return V;
    }

    public int E() {
        int count = 0;
        for (Bag<Edge> b : adj) {
            count += b.size();
        }
        return count;
    }

    public Iterable<Edge> edges() {
        Set<Edge> set = new HashSet<>();
        for(Bag<Edge> b : adj) {
            for (Edge e : b) {
                set.add(e);
            }
        }
        return set;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}
