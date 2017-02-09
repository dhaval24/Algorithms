package com.substringsearch;

/**
 * Created by Dhaval on 11/25/2016.
 * Monte Carlo Version: Strong confidence that no two strings can have same hash and therefore no need to match the substring
 * character by character to check the match.
 *
 * Based on the rolling hash technique
 */
public class RabinKarpPrinceton {

    private long patHash;
    private int M;
    private long Q;
    private int R;
    private long RM; // R ^ (M - 1) % Q

    public RabinKarpPrinceton(String pat) {
        M = pat.length();
        R = 256;
        Q = 997; //should take longRandomPrime() for production though

        RM = 1; // precompute Rpow(m-1)Mod Q
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pat, M);
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }

    public int search(String txt) {

        int N = txt.length();
        long textHash = hash(txt, M);
        if (patHash == textHash) return 0;
        for (int i = M; i < N; i++) {
            textHash = (textHash + Q - RM * txt.charAt(i-M) % Q) % Q;
            textHash = (textHash* R + txt.charAt(i)) % Q;
            if (patHash == textHash) {
                return i - M + 1;
            }
        }
        return N;
    }
}
