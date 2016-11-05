package com.graph;

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

    public boolean[] getMarked() {
        return marked;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }
}
