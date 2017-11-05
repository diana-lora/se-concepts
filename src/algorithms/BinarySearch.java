package algorithms;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int key = 4;
        
        int index = BinarySearch.indexOf(a, key);
        
        if (index > 0) {
            System.out.format("Value %d exists in index %d", key, index);
        } else {
            System.out.println("Value doesn't exists.");
        }
        
    }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a
     *            the array of integers, must be sorted in ascending order
     * @param key
     *            the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
