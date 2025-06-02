package dsa.array.main;

public class BestTimeToBuyAndSellStock {

    //for getting max profit in i-th day, i should have bought it in the minimum of 0 to i-1 -th day

    //TC - O(2n)
    //SC - O(n)
    public static int getMaxProfit_Brut(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int[] minPrices = new int[n];

        //find the left minimum
        int min = prices[0];
        minPrices[0] = min;
        for (int i = 0; i < n; i++) {
            min = Math.min(prices[i], min);
            minPrices[i] = min;
        }

        for (int i = 1; i < n; i++) {
            int cProfit = prices[i] - minPrices[i - 1];
            profit = Math.max(cProfit, profit);
        }

        return profit;
    }

    //TC - O(n)
    //SC - O(1)
    public static int getMaxProfit_Optimal(int[] prices) {
        int profit = 0;
        int n = prices.length;

        //keep track of the min in the same loop
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            int cProfit = prices[i] - min;
            profit = Math.max(cProfit, profit);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
