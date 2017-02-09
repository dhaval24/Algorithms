package com.tries;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dhaval on 11/21/2016.
 */
public class TrieST<Value> {

    private static final int R = 256;
    private Node root = new Node();

    private static class Node {
        Object value;
        Node[] next = new Node[R];
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {

        if (x == null) x = new Node();
        if (d == key.length()) {
            x.value = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Value get(String key) {

        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value)x.value;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);

    }

    public Iterable<String> keys() {
        Queue<String> queue = new LinkedList<>();
        collect(root, "", queue);
        return queue;
    }

    private void collect(Node x, String prefix, Queue<String> queue) {
        if (x == null) return;
        if (x.value != null) {
            queue.add(prefix);
        }
        for (char c = 0; c < R; c++) {
            collect(x.next[c], prefix + c, queue);
        }
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new LinkedList<>();
        Node x = get(root, prefix, 0);
        collect(x, prefix, queue);
        return queue;
    }

    public String longestPrefix(String query) {
        int len = search(root, query, 0, 0);
        return query.substring(0, len);
    }

    private int search(Node x, String query, int d, int len) {
        if (x == null) return len;
        if (x.value != null) len = d;
        if (d == query.length()) return len;
        char c = query.charAt(d);
        return search(x.next[c], query, d+1, len);
    }

    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new LinkedList<>();
        collect(root, pattern, new StringBuilder(), queue);
        return queue;
    }

    private void collect(Node x, String pattern, StringBuilder sb, Queue<String> queue) {
        if (x == null) return;
        int d = sb.length();
        if (d == pattern.length() && x.value != null) {
            queue.add(sb.toString());
        }
        if (d == pattern.length()) {
            return;
        }
        char c = pattern.charAt(d);
        if (c == '.') {
            for (char r = 0; r < R; r++) {
                sb.append(r);
                collect(x.next[r], pattern, sb, queue);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        else {
            sb.append(c);
            collect(x.next[c], pattern, sb, queue);
            sb.deleteCharAt(sb.length()-1);
        }
    }



    public static void main(String[] args) {
        TrieST ts = new TrieST();
        ts.put("She", 10);
        ts.put("Shore", 15);
        ts.put("Apple", 10);
        System.out.println(ts.get("She"));

        for (Object word : ts.keys()) {
            System.out.println((String)word);
        }

        System.out.println("Print string with prefix Sh");
        for (Object word : ts.keysWithPrefix("Sh")) {
            System.out.println(word);
        }

        System.out.println("Longest prefix of Shesam");
        System.out.println(ts.longestPrefix("Shesam"));

        System.out.println("Match pattern Sh..e");
        for(Object word : ts.keysThatMatch("Sh..e")) {
            System.out.println(word);
        }
    }


}
