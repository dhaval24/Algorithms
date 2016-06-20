package com.stackapi;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Dhaval on 6/13/2016.
 * Resizing implementation of stack using arrays.
 * Invariant: array always full between 25% - 75%
 */
public class DynamicCapacityStackOfStrings<T> implements Iterable<T>{

    private T[] s;
    private int N = 0;

    public DynamicCapacityStackOfStrings() {
        s = (T[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    //push element at s[n] and increment n
    public void push(T item) {

        if(N == s.length){
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    // pop s[n-1] element
    public T pop() {
        if(N == 0){
            throw new IndexOutOfBoundsException();
        }
        T item = s[--N];
        if(N > 0 && N == s.length/4){
            resize(s.length/2);
        }
        s[N] = null; // prevents loitering
        return item;
    }

    //Resize the array to double size
    private void resize(int capacity){

        T [] copy = (T[]) new Object[capacity];
        for(int i = 0; i < N; i++){
            copy[i] = s[i];
        }
        s = copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T>{

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() throws NoSuchElementException{

            if(!hasNext()){
                throw new NoSuchElementException();
            }

            return s[--i];
        }

        @Override
        public void remove() throws UnsupportedOperationException{

        }
    }
}
