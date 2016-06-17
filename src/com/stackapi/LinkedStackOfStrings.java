package com.stackapi;

/**
 * Created by Dhaval on 6/13/2016.
 * Constant time operations
 * 40 Byte per Node: 16 bytes object, 8 bytes inner class overhead, 8 bytes for first node
 * reference and 8 byte for new node reference
 */
public class LinkedStackOfStrings {

    private Node first = null;

    /*
        Inner private node class access modifiers dont affect.
     */
    private class Node {

        String item;
        Node next;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

    }

    public String pop() {

        String item = first.item;
        first = first.next;
        return item;

    }
}
