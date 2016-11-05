package com.sorting;

import java.util.Arrays;

/**
 * Created by Dhaval on 10/13/2016.
 */
public class DutchNationalFlag {

    public void sortColors(int[] A) {

        // Three pointers for each color
        // At the end value before pointer i is all 1, value to right of pointer k is all 3 and between i and k are all 2's
        int len = A.length;
        int i = 0;
        int j = 0;
        int k = len - 1;
        while (j <=k) {

            if (A[j] == 1) {
                swap(A, i, j);
                i++;
                j++;
            }

            else if (A[j] == 2) {
                j++;
            }

            else if (A[j] == 3) {
                swap(A, j, k);
                k--;
            }
        }
        System.out.println(Arrays.toString(A));
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        new DutchNationalFlag().sortColors(new int[]{1,1,2,3,2});
    }
}
