package dsa.binarysearch.main;

public class SquareRoot {

    public static int getSquareRoot(int num) {

        // brut force run a loop 1 to num

        if (num == 1) return 1;
        //answer range
        int low = 1;
        int high = num;

        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid * mid) <= num) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
