package com.queueapi;

/**
 * Created by Dhaval on 6/15/2016.
 */
public class LinkedQueue {

    private Node first = null;
    private Node last = null;

    private class Node {

        String item;
        Node next;
    }

    public boolean isEmpty() {

        return first == null;
    }

    public void enqueue(String item) {

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

    public String dequeue() throws QueueUnderFlowException {

        if (isEmpty()) {
            throw new QueueUnderFlowException();
        }
        String remove = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        return remove;
    }
}
