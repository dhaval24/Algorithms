package com.stackapi;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Dhaval on 6/13/2016.
 */
public class StackClient {

    public static void main(String[] args) {

        //LinkedStackOfStrings stack = new LinkedStackOfStrings();
        DynamicCapacityStackOfStrings stack = new DynamicCapacityStackOfStrings();
        while(!StdIn.isEmpty()){

            String s = StdIn.readString();
            if(s.equals("-")){
                StdOut.print(stack.pop());
            }
            else{
                stack.push(s);
            }
        }
    }
}
