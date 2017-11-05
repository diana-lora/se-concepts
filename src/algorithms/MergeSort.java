package algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[] { 1, 4, 3, 2, 6, 5 };
        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] values) {
        int n = values.length;
        mergesort(0, n - 1, values);
    }

    private static void mergesort(int low, int high, int[] values) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle, values);
            // Sort the right side of the array
            mergesort(middle + 1, high, values);
            // Combine them both
            merge(low, middle, high, values);
        }
    }

    private static void merge(int low, int middle, int high, int[] values) {

        // Find sizes of two sub-arrays to be merged
        int n1 = middle - low + 1;
        int n2 = high - middle;

        /* Create temporal arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temporal arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = values[low + i];
        for (int j = 0; j < n2; ++j)
            R[j] = values[middle + 1 + j];

        /* Merge the temporal arrays */

        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array array
        int k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                values[k] = L[i];
                i++;
            } else {
                values[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            values[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            values[k] = R[j];
            j++;
            k++;
        }
    }
}
