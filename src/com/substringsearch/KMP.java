package com.substringsearch;

/**
 * Created by Dhaval on 11/24/2016.
 * Idea of generating prefix table is to find the longest prefix of the substring that matches its proper suffix
 * Eg : ADA - prefixes {A, AD}
 *            Suffixes {D, DA}
 *            Logest match A = A hence 1
 */
public class KMP {

    private int[] KMPPrefix(String pattern) {
        int len = pattern.length();
        int[] prefixTable = new int[len];
        int i = 0;
        for (int j = 1; j < len; j++) {
            while (i > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                i = prefixTable[i];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                i = i + 1;
            }
            prefixTable[j] = i;
        }
        return prefixTable;

    }

    public int kmpMatcher(String text, String pattern) {
        return kmpMatcher(text, pattern, KMPPrefix(pattern));
    }

    private int kmpMatcher(String text, String pattern, int[] prefixTable) {
        int texLen = text.length();
        int patternLen = pattern.length();
        int i = 0;
        for (int j = 1; j < texLen; j++) {
            while (i > 0 && pattern.charAt(i) != text.charAt(j)) {
                i = prefixTable[i]; // pick value from prefixTable to jump starting index
            }
            if (pattern.charAt(i) == text.charAt(j)) {
                i = i + 1; // increase starting index by 1
            }
            if (i == patternLen) {
                return j - patternLen + 1; // match found return starting index
            }
        }
        return texLen;
    }


    public static void main(String[] args) {
        KMP k = new KMP();
        String text = "My name is Dhaval";
        String pattern = "Dhav";
        System.out.println(k.kmpMatcher(text, pattern));
    }
}
