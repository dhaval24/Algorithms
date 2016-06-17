package com.threesum;

/**
 * Created by Dhaval on 6/12/2016.
 */
public class ThreeSumBruteForce {

    public static int count(int[] a) {

        int count = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {

                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
