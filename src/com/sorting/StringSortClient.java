package com.sorting;

import edu.princeton.cs.algs4.In;

/**
 * Created by Dhaval on 6/19/2016.
 */
public class StringSortClient {

    public static void main(String[] args) {

        String[] a = In.readStrings(args[0]); // reads string seperated by space
        //.sort(a);
        for(String item : a){
            System.out.println(item);
        }
    }
}
