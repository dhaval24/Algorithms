package com.queueapi;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Dhaval on 6/15/2016.
 */
public class QueueTester {
    public static void main(String[] args) throws QueueUnderFlowException {

        //LinkedQueue queue = new LinkedQueue();
        DynamicArrayQueue queue = new DynamicArrayQueue();
        while(!StdIn.isEmpty()){

            String s = StdIn.readString();
            if(s.equals("-")){
                StdOut.print(queue.dequeue());
            }
            else{
                queue.enqueue(s);
            }
        }
    }
}
