package dsa.greedy.main;

public class LemonadeChange {
    public static boolean isLemonadeChangePossible(int[] input) {
        int five = 0;
        int ten = 0;
        for (int coin : input) {
            if (coin == 5) {
                five++;
            } else if (coin == 10) {
                if (five >= 1) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                //one ten and one five
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
