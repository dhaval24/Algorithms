package com.graph;

import edu.princeton.cs.algs4.Bag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 11/5/2016.
 */
public class EdgeWeightedDigraph {

    private final int V;
    private final Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedEdge> adj(int v)  {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        int count = 0;
        for (Bag<DirectedEdge> b : adj) {
            count += b.size();
        }
        return count;
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> edgeList = new ArrayList<>();
        for(Bag<DirectedEdge> b : adj) {
            for (DirectedEdge e : b) {
                edgeList.add(e);
            }
        }
        return edgeList;
    }
}
