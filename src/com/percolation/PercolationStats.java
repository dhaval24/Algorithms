package com.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by Dhaval on 6/11/2016.
 */
public class PercolationStats {

    private double[] result;
    private double mean;
    private double stddev;
    private int numberExperiment;

    public PercolationStats(int N, int T) {

        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }

        result = new double[T];
        numberExperiment = T;

        for (int i = 0; i < T; i++) {
            int randomI;
            int randomJ;
            int countOpen = 0;
            Percolation percolation = new Percolation(N);
            while (!percolation.percolates()) {

                randomI = StdRandom.uniform(1, N + 1);
                randomJ = StdRandom.uniform(1, N + 1);
                if (!percolation.isOpen(randomI-1, randomJ-1)) {
                    percolation.open(randomI, randomJ);
                    countOpen++;
                }
            }
            result[i] = (double) countOpen / (N * N);

        }

    }

    public double mean() {
        mean = StdStats.mean(result);
        return mean;
    }

    public double stddev() {
        stddev = StdStats.stddev(result);
        return stddev;
    }

    public double confidenceLo() {

        double confidenceLo = (mean - ((1.96 * stddev) / Math.sqrt(numberExperiment)));
        return confidenceLo;
    }

    public double confidenceHi() {

        double confidenceHi = (mean + ((1.96 * stddev) / Math.sqrt(numberExperiment)));
        return confidenceHi;
    }

    public static void main(String[] args) {

        PercolationStats percolationStats = new PercolationStats(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
        System.out.println("mean " + percolationStats.mean());
        System.out.println("stddev" + percolationStats.stddev());
        System.out.println("95% confidence interval" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi());
    }


}
