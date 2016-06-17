package com.queueapi;

/**
 * Created by Dhaval on 6/15/2016.
 */
public class LinkedQueue<T> {

    private Node first = null;
    private Node last = null;

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
