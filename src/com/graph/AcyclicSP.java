package com.graph;

import edu.princeton.cs.algs4.Topological;

/**
 * Created by Dhaval on 11/6/2016.
 */
public class AcyclicSP {

    private edu.princeton.cs.algs4.DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(edu.princeton.cs.algs4.EdgeWeightedDigraph G, int s) {

        edgeTo = new edu.princeton.cs.algs4.DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        Topological topological = new Topological(G);

        for (int v : topological.order()) {
            for (edu.princeton.cs.algs4.DirectedEdge e : G.adj(v)) {
                relax(e);
            }
        }
    }
    private void relax(edu.princeton.cs.algs4.DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }
}
