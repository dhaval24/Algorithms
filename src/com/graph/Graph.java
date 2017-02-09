package com.graph;

import edu.princeton.cs.algs4.Bag;

/**
 * Created by Dhaval on 11/1/2016.
 */
public class Graph {

    private final int V;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

//    public Graph(In in) {
//
//    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V(){
        return V;
    }

    public int E() {
        int count = 0;
        for (int i = 0; i < V; i++) {
            count += adj[i].size();
        }
        return count/2;
    }

//    public String toString() {
//
//    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            max = Math.max(degree(G,v), max);
        }
        return max;
    }

    public static double avergaeDegree(Graph G) {
        return 2 * G.E()/G.V();
    }

    public static int selfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if(v == w) count++;
            }
        }
        return count/2;
    }

}
