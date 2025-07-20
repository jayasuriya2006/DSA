package dsa.array.main;

public class FindMissingRepeatingNumber {

    //TC - O(n ^ 2)
    //SC - O(1)
    public static int[] findMissingAndRepeatingNumber_Brut(int[] arr, int n) {
        //0 index- missing
        //1 index- repeating
        int[] result = new int[2];
        int missing = Integer.MAX_VALUE;
        int repeating = Integer.MIN_VALUE;
        //loop 1 to n
        for (int i = 1; i <= n; i++) {
            int count = 0;
            //check the count
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    count++;
                }
            }
            if (count == 2) repeating = i;
            if (count == 0) missing = i;
            if (repeating != Integer.MIN_VALUE && missing != Integer.MAX_VALUE) {
                result[1] = missing;
                result[0] = repeating;
                break;
            }
        }

        return result;
    }

    //TC - O(N)
    //SC - O(1)
    public static int[] findMissingAndRepeatingNumber_Optimal(int[] arr, int n) {
        //0 index- missing
        //1 index- repeating
        int[] result = new int[2];

        long sum_n = (n * (n + 1)) / 2;
        long sum_n2 = (n * ((n + 1) * (2 * n + 1))) / 6;

        long sum_array = 0;
        long sum2_array = 0;
        for (int i = 0; i < arr.length; i++) {
            sum_array = sum_array + arr[i];
            sum2_array = sum2_array + (arr[i] * arr[i]);
        }

        // (sum 1 to n) - (sum array)  -> nmissing -  repeating = somevalue      => purely on observation
        long eq1 = sum_n - sum_array;

        // // (sum^2 1 to n) - (sum^2 array)  -> repeating^2 - missing^2 = somevalue      => purely on observation
        // (x^2 - y^2) = (x + y) * (x - y) => we know x - y already ->
        //(x + y) * eq1 = somevalue  => x + y = somevalue / eq1
        long eq2 = (sum_n2 - sum2_array) / eq1;

        //(x + y) + (x - y) = eq1 + eq2   => 2X = eq1 + eq2
        int missing = (int) ((eq1 + eq2) / 2);

        //x - y = eq1   => x - eq1 = y
        int repeating = (int) (missing - eq1);

        result[0] = repeating;
        result[1] = missing;
        return result;
    }
}
