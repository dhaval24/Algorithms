package com.threesum;

import java.util.Arrays;

/**
 * Created by Dhaval on 6/13/2016.
        */
public class ThreeSumDelux {

    /**
     * Sort array, choose any two numbers and search if the array contains - sum of 2 selected
     * @param A input array
     * @return count of number of 3 sums pair
     */
    public static int count(int[] A) {

        int count = 0;
        int length = A.length;
        Arrays.sort(A);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int k = Arrays.binarySearch(A, -(A[i] + A[j]));
                System.out.println(k);
                // A[i] < A[j] < A[k] to avoid double counting ( -20, 10, 10)
                if ((k >= 0) && (i < j) && (j  < k)) {
                    System.out.println("======"+A[i] + "  " + A[j] + "  " + A[k]);
                    count++;
                }
            }
        }
        return count;
    }
}
