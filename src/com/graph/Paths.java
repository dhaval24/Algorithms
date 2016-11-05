package com.graph;

import java.util.Stack;

/**
 * Created by Dhaval on 11/1/2016.
 */
public class Paths {

    DepthFirstSearch d;
    public Paths(Graph G, int s) { //preprocessing using Graph API
        d = new DepthFirstSearch(G, s);
    }

    public boolean hasPathTo(int v){ // determine if there is path from S To  V
        return d.getMarked()[v];
    }

    public Iterable<Integer> pathTo(int v) { // Return any path from S to V
        int[] edgeTo = d.getEdgeTo();
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>(); // maintained stack as elements are received in reverse order
        for (int x = v; x != d.getS(); x = edgeTo[x]) { //using edgeTo array to find the path
            path.push(x);
        }
        return path;
    }

    public static void main(String[] args) {
        Graph G = new Graph(5);
        Paths paths = new Paths(G, 2);
        for (int v = 0; v < G.V(); v++) {
            if(paths.hasPathTo(v)){
                System.out.println(v); // all vertices connected to s in graph G
            }
        }
    }
}
