package com.stackapi;

/**
 * Created by Dhaval on 6/13/2016.
 * Resizing implementation of stack using arrays.
 * Invariant: array always full between 25% - 75%
 */
public class DynamicCapacityStackOfStrings {

    private String[] s;
    private int N = 0;

    public DynamicCapacityStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    //push element at s[n] and increment n
    public void push(String item) {

        if(N == s.length){
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    // pop s[n-1] element
    public String pop() {
        if(N == 0){
            throw new IndexOutOfBoundsException();
        }
        String item = s[--N];
        if(N > 0 && N == s.length/4){
            resize(s.length/2);
        }
        s[N] = null; // prevents loitering
        return item;
    }

    //Resize the array to double size
    private void resize(int capacity){

        String [] copy = new String[capacity];
        for(int i = 0; i < N; i++){
            copy[i] = s[i];
        }
        s = copy;
    }
}
