package com.priorityqueue;

/**
 * Created by Dhaval on 10/20/2016.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;
    private int capacity;

    public MaxPQ() {
        capacity = 16;
        pq = (Key[])new Comparable[capacity+1];
    }

    public MaxPQ(int capacity) {
        pq = (Key[])new Comparable[capacity+1]; //Initialize a priority queue of size capacity + 1. Nothing is stored at
                                                //index 0
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return N == 0; // Return true if pq is empty
    }

    public void insert(Key key) {

        if (N >= capacity) {
            resize(capacity*2);
        }
        pq[++N] = key;  //Insert key at the end of the pq
        swim(N); // swim the element up to satisfy the max heap property
    }

    public Key delMax() {

        if (N == 0) throw new ArrayIndexOutOfBoundsException();
        Key max = pq[1]; //return the root which is max
        exch(1, N--); // swap the root with the last element in the pq and reduce the index to virtually remove it
        sink(1); // sink the new root down the heap if needed to satisfy the heap property
        pq[N+1] = null; // prevent loitering
        return max;
    }

    private void swim(int k) {

        while(k > 1 && less(k/2, k)) { // if the element at current index is greater than its parent swap with parent
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {

        while(2 *k <= N) { // if the element at current index is less than their children promote the strongest children
            int j = 2 * k; //left child
            if(j < N && less(j, j+1)) j++; //find largest child
            if(!less(k,j)) break; // parent is not less than the largest child
            exch(k,j); // exchange parent with largest child
            k = j; //continue at new position
        }
    }

    private void resize(int capacity) {
        Key[] newPq = (Key[]) new Comparable[capacity];
        for (int i = 0; i < N; i++) {
            newPq[i] = pq[i];
        }
        pq = newPq;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

}
