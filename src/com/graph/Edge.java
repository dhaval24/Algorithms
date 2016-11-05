package com.graph;

/**
 * Created by Dhaval on 11/4/2016.
 */
public class Edge implements Comparable<Edge> {

    private final int v, w;
    private final double weight;

    public Edge(int v, int w, double weight) { // create weighted edge v-w
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() { return v; } //return arbitrarily any vertex of the edge

    public int other(int vertex) { // return other end point of edge which is not equal to vertex
        if(vertex == v) return w;
        else return v;
    }

    @Override
    public int compareTo(Edge o) { // compare 2 edges based on their weights
        if(this.weight < o.weight) return -1;
        else if (this.weight > o.weight) return +1;
        else return 0;
    }
}
