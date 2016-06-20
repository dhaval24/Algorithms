package com.stackapi;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by Dhaval on 6/13/2016.
 * Constant time operations
 * 40 Byte per Node: 16 bytes object, 8 bytes inner class overhead, 8 bytes for first node
 * reference and 8 byte for new node reference
 */
public class LinkedStackOfStrings<T> implements Iterable<T>{

    private Node first = null;

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() throws NoSuchElementException {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            T item  = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() throws UnsupportedOperationException{
        }
    }
    /*
        Inner private node class access modifiers dont affect.
     */
    private class Node {

        T item;
        Node next;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

    }

    public T pop() {

        T item = first.item;
        first = first.next;
        return item;

    }
}
