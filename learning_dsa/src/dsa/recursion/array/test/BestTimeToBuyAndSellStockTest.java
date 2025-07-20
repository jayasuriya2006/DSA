package dsa.array.test;

import dsa.array.main.BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStockTest {

    /*
    * Input: arr = [10, 7, 5, 8, 11, 9]
      Output: 6
      Explanation: Buy on day 3 (price = 5) and sell on day 5 (price = 11), profit = 11 - 5 = 6.
      * */

    public static void main(String[] args) {
        int[] prices = {10, 7, 5, 8, 11, 9};
        int expectedProfit = 6;

        int res_brut = BestTimeToBuyAndSellStock.getMaxProfit_Brut(prices);
        int res_optimal = BestTimeToBuyAndSellStock.getMaxProfit_Optimal(prices);

        if (res_brut == expectedProfit) {
            System.out.println("........ BRUT - TEST PASSED.........");
        } else {
            System.out.println("........ BRUT - TEST FAILED.........");
        }

        if (res_optimal == expectedProfit) {
            System.out.println("........ OPTIMAL - TEST PASSED.........");
        } else {
            System.out.println("........ OPTIMAL - TEST FAILED.........");
        }
    }
}
