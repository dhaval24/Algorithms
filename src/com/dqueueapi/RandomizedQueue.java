package com.dqueueapi;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Dhaval on 6/25/2016.
 */
public class RandomizedQueue<T> implements Iterable<T> {

    private int tail;
    private int N;
    private T[] s;


    public RandomizedQueue() {
        s = (T[]) new Object[1];
        tail = -1;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {

        return tail == -1;
    }

    public void enqueue(T item) {

        if (item == null) {
            throw new NoSuchElementException();
        }

        if (isEmpty()) {
            tail = 0;
        }

        if (tail >= s.length) {
            resize(2 * s.length);
        }

        s[tail++] = item;
        N++;
    }

    public T dequeue() {

        if (isEmpty()) {
            throw new UnsupportedOperationException();
        }

        int random = StdRandom.uniform(tail + 1);
        T item = s[random];
        s[random] = s[tail];
        s[tail] = null;
        tail--;
        N--;
        return item;

    }

    public T sample() {

        if (isEmpty()) {
            throw new UnsupportedOperationException();
        }

        int random = StdRandom.uniform(tail + 1);
        T item = s[random];
        return item;
    }


    private void resize(int capacity) {

        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < s.length; i++) {
            copy[i] = s[i];
        }
        s = copy;

    }


    @Override
    public Iterator<T> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator<T> implements Iterator<T> {

        int[] r = new int[tail];
        int count = 0;

        private void shuffle() {
            for (int i = 0; i < r.length; i++) {
                int random = StdRandom.uniform(i + 1);
                exch(r, i, random);
            }
        }

        public RandomizedIterator() {
            shuffle();
        }

        private void exch(int[] a, int i, int j) {
            a[i] = j;
            a[j] = i;
        }

        @Override
        public boolean hasNext() {
            return count < r.length;
        }

        @Override
        public T next() {
            return (T) s[count++];
        }

        @Override
        public void remove() {
            throw new NoSuchElementException();
        }
    }
}
