package com.substringsearch;

/**
 * Created by Dhaval on 11/25/2016.
 * Intution: Huristic skipping based on mismatch
 * Algorithm: Precompute the steps to skip based on the last occurance of the character in the needle
 * start iterating over the text matching with pattern from Right to Left. If there is a mismatch then if the character mismatched in the
 * text is not in pattern then we can skip characters equal to the length of the pattern
 * Else we will find the max character to skip between 1 and the j-right[txt.charAt(i+j)] which is infact an effort to align the text
 * to the matching character in the pattern
 *
 * At the end if we find that skip is 0 that means we matched all characters in the pattern and therefore return the index i which would
 * be the starting point.
 *
 * Practical complexity - O(N/M) where N is length of text and M is length of pattern
 * Can run into worst case of O(NM)
 */
public class BoyerMore {

    private static final int R = 256;

    public int search(String txt, String pattern) {

        int n = txt.length();
        int m = pattern.length();
        if (m > n) return -1; // cant be possible
        int[] right = new int[R];
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            right[pattern.charAt(i)] = i;
        }
        int skip;
        for (int i = 0; i < n-m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pattern.charAt(j) != txt.charAt(i+j)) {
                    skip = Math.max(1, j - right[txt.charAt(i+j)]); // max because no back-up, skip value is atleast 1
                    break;
                }
            }

            if (skip == 0) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new BoyerMore().search("findinahaystackneedlein", "needle"));
    }
}
