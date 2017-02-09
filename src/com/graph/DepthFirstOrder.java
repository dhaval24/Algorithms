package com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Dhaval on 1/22/2017.
 */
public class DepthFirstOrder {

    private boolean[] marked;
    private int[] pre;
    private int[] post;
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private int preCounter;
    private int postCounter;

    public DepthFirstOrder(Digraph G) {
        pre = new int[G.V()];
        post = new int[G.V()];
        preOrder = new LinkedList<>();
        postOrder = new LinkedList<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preOrder.offer(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
        postOrder.offer(v);
        post[v] = postCounter++;
    }

    public Iterable<Integer> pre() {
        return preOrder;
    }

    public Iterable<Integer> post() {
        return postOrder;
    }

    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<>();
        for (int v : postOrder) {
            reverse.push(v);
        }
        return reverse;
    }

    public int pre(int v) {
        return pre[v];
    }

    public int post(int v) {
        return post[v];
    }

}
