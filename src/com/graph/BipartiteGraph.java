package com.graph;

/**
 * Created by Dhaval on 1/21/2017.
 */
public class BipartiteGraph {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public BipartiteGraph(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            dfs(G, v);
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
            }
            else if (color[w] == color[v]) isTwoColorable = true;
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
