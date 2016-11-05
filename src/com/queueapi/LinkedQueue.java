package com.queueapi;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by Dhaval on 6/15/2016.
 */
public class LinkedQueue<T> implements Iterable<T> {

    private Node first = null;
    private Node last = null;

    @Override
    public Iterator<T> iterator() {
        return new LinkQueueIterator();
    }

    private class LinkQueueIterator implements Iterator<T>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() throws NoSuchElementException{
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() throws UnsupportedOperationException{

        }
    }

    private class Node {

        T item;
        Node next;
    }

    public boolean isEmpty() {

        return first == null;
    }

    public void enqueue(T item) {

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }
        else{
            oldLast.next = last;
        }


    }

    public T dequeue() throws QueueUnderFlowException {

        if (isEmpty()) {
            throw new QueueUnderFlowException();
        }
        T remove = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        return remove;
    }
}
