package com.dynamic.connectivity;

/**
 * Created by Dhaval on 6/11/2016.
 */
public class QuickUnion {

    private int[] id;

    /**
     * Initialize the array of objects with its numbers
     * @param N
     */
    public QuickUnion(int N) {

        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    /**
     * Returns the root of an element by tracing its parents until the value of parent is equal to itself
     * @param i
     * @return root
     */
    private int findRoot(int i){

        while(i != id[i]){
            i = id[i];
        }

        return i;
    }

    /**
     * Check if two objects have same root if so return true
     * @param p object 1
     * @param q object 2
     * @return true/false
     */
    public boolean isConnected(int p, int q){
        return findRoot(p) == findRoot(q);
    }

    /**
     * Assign the root of q to root of p to perform union
     * @param p object 1
     * @param q object 2
     */
    public void union(int p, int q){

        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        id[rootP] = rootQ;
    }
}
