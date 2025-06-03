package dsa.twopointer.test;

import dsa.twopointer.main.FruitIntoBaskets;

public class FruitIntoBasketsTest {
    /*
        You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

       * You only have two baskets, and each basket can only hold a single type of fruit.
        There is no limit on the amount of fruit each basket can hold.

       * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
        while moving to the right. The picked fruits must fit in one of your baskets.

       * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

     */
    public static void main(String[] args) {

        int[] fruits = {};
        // Output: 0

        //int[] fruits = {0, 1, 0, 1, 0, 1};
        // Output: 6


        //int[] fruits = {1, 2, 3, 4, 5};
        // Output: 2

        // int[] num = {1, 2, 2, 2, 2, 3, 4, 4, 4, 2, 1, 1};
        // out put 5

        System.out.println(FruitIntoBaskets.brute(fruits));
        System.out.println(FruitIntoBaskets.optimal(fruits));
    }
}
