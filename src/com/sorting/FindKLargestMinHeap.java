package com.sorting;

/**
 * Created by Dhaval on 10/24/2016.
 */
public class FindKLargestMinHeap {

    public void findKLargestHeap(Comparable[] a, int k) {

        Comparable[] minHeapK = new Comparable[k+1];
        constructMinHeap(a, minHeapK, k);
        System.out.println("----heap initial---");
//        for (Comparable t : minHeapK) {
//            System.out.println(t);
//        }

        int len = a.length;
        for (int i = k; i < len; i++) {
            if (minHeapK[1].compareTo(a[i]) < 0) {
                minHeapK[1] = a[i];
                sink(minHeapK, 1, k);
            }
        }
        for (Comparable t : minHeapK) {
            System.out.println(t);
        }

    }

    private void constructMinHeap(Comparable[] a, Comparable[] minHeapK, int k) {

        for(int i = 1; i < k+1; i++) {
            minHeapK[i] = a[i-1];
            swim(minHeapK, i);
        }
    }

    private void swim(Comparable[] minHeapK, int no) {
        while(no > 1 && less(minHeapK, no, no/2)) {
            exch(minHeapK, no, no/2);
            no = no/2;
        }
    }

    private void sink(Comparable[] minHeapK, int no, int len) {
        while(2*no <= len) {
            int j = 2*no;
            if (j < len && less(minHeapK, j+1, j)) j++;
            if (!less(minHeapK, j, no)) break;
            exch(minHeapK, j, no);
            no = j;

        }
    }

    private boolean less(Comparable[] minHeapK, int i, int j) {
        return minHeapK[i].compareTo(minHeapK[j]) < 0;
    }

    private void exch(Comparable[] minHeapK, int i, int j) {
        Comparable temp = minHeapK[i];
        minHeapK[i] = minHeapK[j];
        minHeapK[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] inp = {4,5,2,3,7,6,1};
        new FindKLargestMinHeap().findKLargestHeap(inp, 7);
    }
}
