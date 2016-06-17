package com.dynamic.connectivity;

/**
 * @author Dhaval
 * @version 1.0
 * @since 06/11/16
 */
public class QuickFind {

    private int[] id;

    /**
     * Initialize the id constructor to initial values
     * @param N total number of objects
     */
    public QuickFind(int N) {

        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }

    }

    /**
     *
     * @param p Object 1
     * @param q Object 2
     * @return if 2 objects are connected
     */
    public boolean isConnected(int p, int q){

        return id[p] == id[q];
    }

    /**
     * Performs union on two objects by changing all those elements in id[] who have value id[p]
     * to id[q]. Linear time for single union command.
     * @param p
     * @param q
     */
    public void union(int p, int q){

        int pID = id[p];
        int qID = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
    }
}
