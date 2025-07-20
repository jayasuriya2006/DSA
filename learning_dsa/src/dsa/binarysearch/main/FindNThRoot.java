package dsa.binarysearch.main;

public class FindNThRoot {

    public static int findNthRoot(int n, int num) {
        if (num == 0) return 0;
        int low = 1;
        int high = num;

        while (low <= high) {
            int mid = (low + high) / 2;
            int temp = checkForNthRoot(num, mid, n);
            if (temp == 0) {
                return mid;
            } else if (temp == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int checkForNthRoot(int num, int mid, int n) {
        long mul = 1;
        for (int i = 0; i < n; i++) {
            mul = mul * mid;
            if (mul > num) return 2;
        }
        if (mul == num) return 0;
        return 1;
    }
}
