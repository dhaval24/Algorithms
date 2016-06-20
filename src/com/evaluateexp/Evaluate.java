package com.evaluateexp;

import com.stackapi.LinkedStackOfStrings;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Dhaval on 6/18/2016.
 */
public class Evaluate {

    public static void main(String[] args) {

        LinkedStackOfStrings<String> ops = new LinkedStackOfStrings<>();
        LinkedStackOfStrings<Double> vals = new LinkedStackOfStrings<>();
        while(!StdIn.isEmpty()){

            String s = StdIn.readString();
            System.out.println(s);
            if(s.equals("(")){}
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals(")")){

                String op = ops.pop();
                if (op.equals("+"))
                    vals.push(vals.pop() + vals.pop());
                else if (op.equals("*"))
                    vals.push(vals.pop() * vals.pop());
            }
            else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
