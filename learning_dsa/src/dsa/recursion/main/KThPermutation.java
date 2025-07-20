package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class KThPermutation {

    public static String getKThPermutation(int n, int k) {
        String kthPermutation = "";


        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);

        int item = k - 1; //0 based index

        while (true) {
            int curNumber = numbers.get((item / fact));
            kthPermutation = kthPermutation + curNumber;
            numbers.remove(item / fact);
            if (numbers.isEmpty()) {
                break;
            }

            item = item % fact;
            fact = fact / numbers.size();

        }
        return kthPermutation;
    }
}
