package com.graph;

import java.util.Stack;

/**
 * Created by Dhaval on 11/1/2016.
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    public int getS() {
        return s;
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G,w);
                edgeTo[w] = v;
            }
        }
    }

    //returns true if there is a path from given source vertex to given vertex
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    //Returns path from source node to given vertex if there is a path available.
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }

    public boolean[] getMarked() {
        return marked;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }
}
