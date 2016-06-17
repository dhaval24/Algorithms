package com.dynamic.connectivity;

/**
 * Created by Dhaval on 6/11/2016.
 */
public class WeightedQuickUnion {

    private int[] id;
    private int[] size;

    /**
     * Initialize the id array of objects with its numbers and size array with 1 as
     * initially each node is a root
     * @param N
     */
    public WeightedQuickUnion(int N) {

        id = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
            size[i] = 1;
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
     * Assign the root of smaller tree to the root of larger tree among p and q
     * and update the size of tree accordingly
     * @param p object 1
     * @param q object 2
     */
    public void union(int p, int q){

        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        if(size[rootP] < size[rootQ]){
            id[rootP] = rootQ;
            size[rootQ] += size[rootP]; // rootP is assigned the value of rootQ and hence increase the size of rootQ by rootP
        }
        else{
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

    }
}
