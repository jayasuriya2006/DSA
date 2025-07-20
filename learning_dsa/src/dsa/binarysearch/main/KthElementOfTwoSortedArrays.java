package dsa.binarysearch.main;

public class KthElementOfTwoSortedArrays {
    //Binary Search
    public static int findKthElement(int[] arr1, int[] arr2, int k) {
        if (arr2.length < arr1.length) {
            return findKthElement(arr2, arr1, k);
        }

        int n1 = arr1.length;
        int n2 = arr2.length;
        int leftElements = k;            // 1 added, so that same approach for even and odd

        int low = Math.max(0, k - n2);
        int high = Math.min(n1, k);

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = leftElements - mid1;

            int l1 = (mid1 - 1) >= 0 && (mid1 - 1) < n1 ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1) >= 0 && (mid2 - 1) < n2 ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1) >= 0 && (mid1) < n1 ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2) >= 0 && (mid2) < n2 ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
