package dsa.dp.main;

public class BuyAndSellStock {

    //TC - O(N)
    //SC - O(1)
    public static int getMaxProfit(int[] price) {
        int n = price.length;
        if (n == 0) return 0;
        int min = price[0];
        int maxProfit = 0;
        for (int day = 1; day < n; day++) {
            if (price[day] >= min) {
                maxProfit = Math.max(maxProfit, price[day] - min);
            } else {
                min = price[day];
            }
        }
        return maxProfit;
    }
}
