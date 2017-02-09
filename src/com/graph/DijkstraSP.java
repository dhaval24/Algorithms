package com.graph;

import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * Created by Dhaval on 11/5/2016.
 */
public class DijkstraSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY; // Distance to all vertices is positive infinity initially
        }
        distTo[s] = 0.0; // Distance to source is 0, these are fundamental assumptions for Dijkstra's Algorithm

        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : G.adj(v)) {
                relax(e); // Function which updates the shortest path till w(end point of e) by considering edge e
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w= e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]); // update PQ with updated shortest path till W
            }
            else {
                pq.insert(w, distTo[w]);
            }
        }
    }
}
