package com.tries;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 11/24/2016.
 */
public class TST<Value> {

    private Node root;

    private class Node {
        char ch;
        Value val;
        Node left, middle, right;
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int indx) {

        char c = key.charAt(indx);
        if (x == null) {
            x = new Node();
            x.ch = c;
        }
        if (c < x.ch) {
            x.left = put(x.left, key, value, indx);
        }
        else if(c > x.ch) {
            x.right = put(x.right, key, value, indx);
        }
        else if (indx < key.length() - 1) {
            x.middle = put(x.middle, key, value, indx+1);
        }
        else {
            x.val = value;
        }
        return x;
    }

    public Value get(String key) {
        if (key == null) return null;
        Node x = get(root, key, 0);
        if (x == null) return null;
        else return x.val;
    }

    private Node get(Node x, String key, int indx) {
        if (x == null) return null;
        char c = key.charAt(indx);
        if (c < x.ch) {
            return get(x.left, key, indx);
        }
        else if (c > x.ch) {
            return get(x.right, key, indx);
        }
        else if(indx < key.length() - 1) {
            return get(x.middle, key, indx+1);
        }
        else {
            return x;
        }
    }

    public boolean containsKey(String key) {
        return get(key) != null;
    }

    public Iterable<String> keys() {
        Queue<String> queue = new LinkedList<>();
        collect(root, "", queue);
        return queue;
    }

    private void collect(Node x, String prefix, Queue<String> queue) {
        if (x == null) return;
        if (x.val != null) {
            queue.add(prefix + x.ch);
        }
        collect(x.left, prefix, queue);
        collect(x.middle, prefix + x.ch, queue);
        collect(x.right, prefix, queue);

    }

    public Iterable<String> keyWithPrefix(String prefix) {
        Queue<String> queue = new LinkedList<>();
        Node x = get(root, prefix, 0);
        collect(x, prefix.substring(0,prefix.length()-1), queue);
        return queue;
    }

    public String longestPrefixOf(String query) {
        int len = search(root, query, 0, 0);
        String ret = len == 0 ? "" : query.substring(0, len+1);
        return ret;

    }

    private int search(Node x, String query, int d, int len) {
        if (x == null) return len;
        if (d == query.length()) return len;
        char c = query.charAt(d);
        if (x.val != null && x.ch == c) len = d;
        if (c < x.ch) {
            return search(x.left, query, d, len);
        }
        else if (c > x.ch) {
            return search(x.right, query, d, len);
        }
        else if (d < query.length() -1) {
            return search(x.middle, query, d+1, len);
        }
        return len;
    }

    public static void main(String[] args) {
        TST t = new TST();
        t.put("she", 10);
        t.put("shore", 12);
        t.put("apple", 5);
        System.out.println(t.get("she"));
        System.out.println(t.get("shore"));
        System.out.println(t.get("apple"));
        System.out.println(t.get("ball"));

        for (Object word : t.keys()) {
            System.out.println(word);
        }

        System.out.println("Print keys with prefix sh");
        for (Object word : t.keyWithPrefix("sh")) {
            System.out.println(word);
        }

        System.out.println("Longest prefix of shorec is: " + t.longestPrefixOf("shored"));
    }
}
