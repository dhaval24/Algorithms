package com.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 11/1/2016.
 */
public class BreadhFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadhFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        while(!q.isEmpty()) {
            int v = q.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }
}
