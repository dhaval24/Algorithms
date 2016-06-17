package com.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Dhaval on 6/11/2016.
 */

public class Percolation {


    private boolean[][] grid;
    private int virtualTop;
    private int virtualBottom;
    private WeightedQuickUnionUF pcWeightedQuickUnion;

    public Percolation(int N) {

        if (N <= 0) {
            throw new IllegalArgumentException();
        }

        grid = new boolean[N][N];
        pcWeightedQuickUnion = new WeightedQuickUnionUF(N * N + 2);
        virtualTop = 0;
        virtualBottom = N * N + 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0)
                    grid[i][j] = false;
            }
        }

    }


    public void open(int i, int j) {

        i = i - 1;
        j = j - 1;
        if (!grid[i][j]) {
            grid[i][j] = true;
            if (i == 0) {
                pcWeightedQuickUnion.union(getIndex(i, j), virtualTop);
            }
            else if (i == grid.length - 1) {
                pcWeightedQuickUnion.union(getIndex(i, j), virtualBottom);
            }
            else if(j == grid.length -1){
                if (isOpen(i - 1, j)) {
                    pcWeightedQuickUnion.union(getIndex(i - 1, j), getIndex(i, j));
                }
                if (isOpen(i + 1, j)) {
                    pcWeightedQuickUnion.union(getIndex(i + 1, j), getIndex(i, j));
                }
                if (isOpen(i, j - 1)) {
                    pcWeightedQuickUnion.union(getIndex(i, j - 1), getIndex(i, j));
                }
            }
            else if (j == 0){
                if (isOpen(i - 1, j)) {
                    pcWeightedQuickUnion.union(getIndex(i - 1, j), getIndex(i, j));
                }
                if (isOpen(i + 1, j)) {
                    pcWeightedQuickUnion.union(getIndex(i + 1, j), getIndex(i, j));
                }
                if (isOpen(i, j + 1)) {
                    pcWeightedQuickUnion.union(getIndex(i, j + 1), getIndex(i, j));
                }
            }
            else if (i > 0 && j > 0 && i < grid.length - 1   && j < grid.length - 1 ) {
                if (isOpen(i - 1, j)) {
                    pcWeightedQuickUnion.union(getIndex(i - 1, j), getIndex(i, j));
                }
                if (isOpen(i + 1, j)) {
                    pcWeightedQuickUnion.union(getIndex(i + 1, j), getIndex(i, j));
                }
                if (isOpen(i, j + 1)) {
                    pcWeightedQuickUnion.union(getIndex(i, j + 1), getIndex(i, j));
                }
                if (isOpen(i, j - 1)) {
                    pcWeightedQuickUnion.union(getIndex(i, j - 1), getIndex(i, j));
                }
            }
        }

    }

    private int getIndex(int i, int j) {

        //System.out.println((grid.length * (i - 1)) + j);
        return (grid.length * (i)) + j;
    }

    public boolean isOpen(int i, int j) {

        return grid[i][j];
    }

    public boolean isFull(int i, int j) {

        return pcWeightedQuickUnion.connected(getIndex(i, j), virtualTop);
    }

    public boolean percolates() {

        return pcWeightedQuickUnion.connected(virtualTop, virtualBottom);

    }

}
