package com.graph;

import java.util.Stack;

/**
 * Created by Dhaval on 1/21/2017.
 */
public class IterativeDFS {

    private int[] edgeTo;
    private boolean[] marked;
    private Stack<Integer> stack;
    private int s;

    public IterativeDFS(Graph G, int source) {
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        s = source;
        stack = new Stack<>();
        iterativeDfs(G, stack, s);
    }

    public void iterativeDfs(Graph G, Stack<Integer> stack, int v) {

        stack.push(v);
        while(!stack.isEmpty()) {
            int s = stack.pop();
            marked[s] = true;
            System.out.println(" " + s + " ");
            for (int w : G.adj(s)) {
                stack.push(w);
                edgeTo[w] = s;
            }
        }
    }
}
