package dsa.recursion.main;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> getAllPalindromePartitionSusStrings(String input) {
        List<List<String>> result = new ArrayList<>();
        getAllPalindromePartitionSusStrings(input, result, new ArrayList<>(), 0);
        return result;
    }

    private static void getAllPalindromePartitionSusStrings(String input, List<List<String>> result, List<String> curPartition, int start) {

        if (start == input.length()) {
            result.add(new ArrayList<>(curPartition));
            return;
        }

        for (int index = start; index < input.length(); index++) {
            if (isPalindrome(start, index, input)) {
                curPartition.add(input.substring(start, index + 1));
                getAllPalindromePartitionSusStrings(input, result, curPartition, index + 1);
                curPartition.remove(curPartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(int start, int end, String input) {
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
