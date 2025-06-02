package dsa.array.main;

public class MaximumProductSubarray {

    //TC - O( N^3)
    //SC - O(1)
    public static long getMaxSubArrayProduct_Brut(int[] arr) {
        long maxProduct = Long.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long product = 1;
                for (int k = i; k <= j; k++) {
                    product = product * arr[k];
                }
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    //TC - O( N^2)
    //SC - O(1)
    public static long getMaxSubArrayProduct_Better(int[] arr) {
        long maxProduct = Long.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            long product = 1;
            for (int j = i; j < n; j++) {
                product = product * arr[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    //Observations -
    //    zeros - just ignore
    //    odd negative - either prefix or suffix
    //    even negative - complete product
    //TC - O(n)
    //SC - O(1)
    public static long getMaxSubArrayProduct_Optimal(int[] arr) {
        long maxProduct = Long.MIN_VALUE;
        int n = arr.length;
        long preProduct = 1;
        long sufProduct = 1;
        for (int i = 0; i < n; i++) {
            //ignoring zeros, no need to carry
            if (preProduct == 0) {
                preProduct = 1;
            }
            if (sufProduct == 0) {
                sufProduct = 1;
            }

            preProduct = preProduct * arr[i];
            sufProduct = sufProduct * arr[n - 1 - i];
            maxProduct = Math.max(maxProduct, preProduct);
            maxProduct = Math.max(maxProduct, sufProduct);
        }
        return maxProduct;
    }


}
