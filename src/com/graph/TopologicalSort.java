package com.graph;

import java.util.Stack;

/**
 * Created by Dhaval on 1/22/2017.
 */
public class TopologicalSort {

    private boolean[] marked;
    private Stack<Integer> reversePostOrder;

    public TopologicalSort(Digraph G) {
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            marked = new boolean[G.V()];
            reversePostOrder = new Stack<>();
            for (int i = 0; i < G.V(); i++) {
                if (!marked[i]) dfs(G, i);
            }
        }
        else {
            throw new IllegalArgumentException("Graph has cycles");
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
        reversePostOrder.push(v);
    }

    private Iterable<Integer> reversePost() {
        return reversePostOrder;
    }

    public Iterable<Integer> performTopologicalSort() {
        return reversePost();
    }
}
