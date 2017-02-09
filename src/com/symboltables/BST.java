package com.symboltables;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 10/21/2016.
 */
public class BST<Key extends Comparable<Key>, Value> implements Iterable<Key>{

    private Node root;
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        }
        else if (cmp > 0) {
            x.right = put(x.right, key, value);
        }
        else x.value = value;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    public Value get(Key key) {
        Node temp = root;
        while (temp != null) {
            if (temp.key.compareTo(key) < 0) {
                temp = temp.right;
            }
            else if (temp.key.compareTo(key) > 0) {
                temp = temp.left;
            }
            else {
                return temp.value;
            }
        }
        return null;
    }

    public Key max() {
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.key;
    }

    public Key min() {
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;

        }
        return temp.key;
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }




    @Override
    public Iterator<Key> iterator() {
        Queue<Key> q = new LinkedList<Key>();
        inorder(root, q);
        return q.iterator();
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

}
