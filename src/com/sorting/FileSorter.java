package com.sorting;

import java.io.File;

/**
 * Created by Dhaval on 6/19/2016.
 */
public class FileSorter {

    public static void main(String[] args) {

        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        //.sort(files);
        for(int i = 0; i < files.length; i++){
            System.out.println(files[i].getName());
        }
    }
}
