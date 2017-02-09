package com.graph;

/**
 * Created by Dhaval on 1/21/2017.
 * This code finds cycle in Undirected Graph
 */
public class DetectCycle {

    private boolean[] marked;
    private int[] edgeTo;
    int S;
    private boolean hasCycle;

    public DetectCycle(Graph G, int source) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        S = source;
        dfs(G, S, S);
    }

    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        edgeTo[v] = u;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            }
            else if (w != u) hasCycle = true;
        }
    }

    public boolean containsCycle() {
        return hasCycle;
    }
}
