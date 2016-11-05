package com;

/**
 * Created by Dhaval on 9/23/2016.
 */
public class RabinKarp {

    public int patternMatch(String s, String pattern) {

        if (s == "" ) { throw new NullPointerException(); }

        int prime = 101;
        int len = s.length();
        int patternLen = pattern.length();
        long patternHash = createHash(pattern, 0, patternLen, prime);
        long movingHash = createHash(s, 0, patternLen, prime);
        for (int i = 1; i <= len - patternLen + 1; i++) {

            if (movingHash == patternHash && isSameString(s.substring(i-1, i+patternLen-1), pattern, patternLen)) {
                return i - 1;
            }
            else {
                movingHash = recalculateHash(movingHash, s.substring(i-1, i+patternLen), prime, patternLen);
            }
        }
        return -1;


    }

    private long createHash(String s, int startIndex, int endIndex, int prime) {
        int count = 0;
        long hash = 0;
        for (int i = startIndex; i < endIndex; i++) {
            hash += (s.charAt(i) * (int)Math.pow(prime, count));
            count++;
        }
        return hash;

    }

    private long recalculateHash(long movingHash, String s,int prime, int len) {
        long hash = movingHash - s.charAt(0);
        hash = hash/prime;
        hash += s.charAt(len) * Math.pow(prime, len-1);
        return hash;
    }

    private boolean isSameString(String s1, String s2, int len) {
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new RabinKarp().patternMatch("Dhaval UIC to UIC", "UIC"));
    }
}
