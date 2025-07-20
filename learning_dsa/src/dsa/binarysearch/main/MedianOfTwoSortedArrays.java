package dsa.binarysearch.main;

public class MedianOfTwoSortedArrays {

    //merge two arrays
    public static double getMedian_Brut(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] merged = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            merged[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }
        while (i < n1) {
            merged[k++] = arr1[i++];
        }

        while (j < n2) {
            merged[k++] = arr2[j++];
        }

        if ((n1 + n2) % 2 == 1) {
            return merged[(n1 + n2) / 2];
        } else {
            int mid = (n1 + n2) / 2;
            int sum = merged[mid] + merged[mid - 1];
            return sum / 2.0;
        }

    }


    public static double getMedian_Better(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;
        int reqIndex1 = ((n1 + n2) / 2) - 1;
        int reqIndex2 = ((n1 + n2) / 2);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (e1 != Integer.MIN_VALUE && e2 != Integer.MIN_VALUE) break;

            if (arr1[i] < arr2[j]) {
                if (k == reqIndex1) e1 = arr1[i];
                if (k == reqIndex2) e2 = arr1[i];
                i++;
            } else {
                if (k == reqIndex1) e1 = arr2[j];
                if (k == reqIndex2) e2 = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            if (e1 != Integer.MIN_VALUE && e2 != Integer.MIN_VALUE) break;
            if (k == reqIndex1) e1 = arr1[i];
            if (k == reqIndex2) e2 = arr1[i];
            i++;
            k++;
        }

        while (j < n2) {
            if (e1 != Integer.MIN_VALUE && e2 != Integer.MIN_VALUE) break;
            if (k == reqIndex1) e1 = arr2[j];
            if (k == reqIndex2) e2 = arr2[j];
            j++;
            k++;
        }

        if ((n1 + n2) % 2 == 1) {
            return e2;
        } else {
            int sum = e1 + e2;
            return sum / 2.0;
        }

    }

    //Binary Search
    public static double getMedian_Optimal(int[] arr1, int[] arr2) {
        if(arr2.length < arr1.length) {
            return getMedian_Optimal(arr2, arr1);
        }

        int n1 = arr1.length;
        int n2 = arr2.length;
        int leftElements = (n1 + n2 + 1) / 2;            // 1 added, so that same approach for even and odd

        int low = 0;
        int high = n1;

        while(low <= high){
            int mid1 = (low + high) / 2;
            int mid2 = leftElements - mid1;

            int l1 = (mid1 - 1) >= 0 && (mid1 - 1) < n1 ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1) >= 0 && (mid2 - 1) < n2 ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1) >= 0 && (mid1) < n1 ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2) >= 0 && (mid2) < n2 ? arr2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if((n1 + n2) % 2 == 0) {
                    int sum = Math.max(l1, l2) + Math.min(r1, r2);
                    return sum / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if(l1 > r2){
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0.0;
    }
}
