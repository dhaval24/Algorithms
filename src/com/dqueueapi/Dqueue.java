package com.dqueueapi;

import com.queueapi.QueueUnderFlowException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Dhaval on 6/22/2016.
 */
public class Dqueue<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new DqueueIterator();
    }

    private class DqueueIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {

        T item;
        Node next;
        Node prev;

    }

    public Dqueue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(T item) {

        if(item == null) {
            throw new NoSuchElementException();
        }

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldFirst.prev = first;
        }
        N++;
    }

    public void addLast(T item) {

        if(item == null) {
            throw new NoSuchElementException();
        }

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
            last.prev = oldLast;
        }
        N++;
    }

    public T removeFirst(T item) throws QueueUnderFlowException {

        if (isEmpty()) {
            throw new UnsupportedOperationException();
        }
        T remove = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return remove;
    }

    public T removeLast(T item) throws QueueUnderFlowException {

        if (isEmpty()) {
            throw new UnsupportedOperationException();
        }

        T remove = last.item;
        last = last.prev;
        if (isEmpty()) {
            first = last;
        }
        N--;
        return remove;

    }

    public int size() {
        return N;
    }
}
