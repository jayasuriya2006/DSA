package dsa.greedy.main;

import java.util.ArrayList;
import java.util.List;

public class FractionalKnapsackAlgorithm {

    public static float getMaxProfit(int[] values, int[] weights, int capacity) {
        float maxProfit = 0F;
        int n = values.length;
        List<Item> itemsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemsList.add(new Item(values[i], weights[i]));
        }

        //sort based on value per 1 unit of weight -> so that we can obtain max profit
        itemsList.sort((a, b) -> Double.compare(
                (double) b.value / b.weight,
                (double) a.value / a.weight
        ));
        int remainingCap = capacity;
        for (int i = 0; i < n; i++) {
            if (remainingCap == 0) break;

            Item curItem = itemsList.get(i);

            //full value
            if (curItem.weight <= remainingCap) {
                maxProfit = maxProfit + curItem.value;
                remainingCap = remainingCap - curItem.weight;
                continue;
            }

            //fractional value
            //one unit weight value * remaining weight
            maxProfit = maxProfit + (curItem.value / curItem.weight) * remainingCap;
            break;
        }
        return maxProfit;
    }
}

class Item {
    int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
