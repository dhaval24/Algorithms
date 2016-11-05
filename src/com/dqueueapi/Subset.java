package com.dqueueapi;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Dhaval on 6/24/2016.
 */
public class Subset {

    public static void main(String[] args) {

        int k = Integer.parseInt(args[0]);
        int count = 0;
        RandomizedQueue<String> dqueue = new RandomizedQueue<>();
        while(!StdIn.isEmpty()) {
            dqueue.enqueue(StdIn.readString());
            count++;
        }

        for(String s : dqueue) {
            if(count <= k) {
                StdOut.print(s);
                count++;
            }
            else{
                break;
            }
        }
    }
}
