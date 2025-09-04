package dsa.graphs.test;

import dsa.graphs.main.WordLadderI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadderITest {
    public static void main(String[] args) {
        WordLadderI solver = new WordLadderI();

        int passed = 0;
        int total = 10;

        // Test Case 1: Basic case
        if (test(solver, "hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"), 5)) passed++;

        // Test Case 2: No path
        if (test(solver, "hit", "cog", Arrays.asList("hot","dot","dog","lot","log"), 0)) passed++;

        // Test Case 3: Direct change
        if (test(solver, "a", "c", Arrays.asList("a","b","c"), 2)) passed++;

        // Test Case 4: Begin = End (should return 1 if beginWord == endWord and it's in the list)
        if (test(solver, "hit", "hit", Arrays.asList("hit"), 1)) passed++;

        // Test Case 5: Long chain
        //if (test(solver, "hit", "cog", Arrays.asList("hot","dot","dop","cop","cog"), 5)) passed++;

        // Test Case 6: Word list has unrelated words
        if (test(solver, "hit", "cog", Arrays.asList("abc","def","ghi","hot","dot","dog","lot","log","cog"), 5)) passed++;

        // Test Case 7: Case-sensitive input (should fail if not matching)
        if (test(solver, "Hit", "Cog", Arrays.asList("hot","dot","dog","lot","log","cog"), 0)) passed++;

        // Test Case 8: Circular path protection (duplicate entries)
        if (test(solver, "hit", "cog", Arrays.asList("hot","dot","dog","dog","lot","log","cog"), 5)) passed++;

        // Test Case 9: No endWord in list
        if (test(solver, "hit", "cog", Arrays.asList("hot","dot","dog","lot","log"), 0)) passed++;

        // Test Case 10: Large word list, no valid path
        if (test(solver, "hit", "zzz", generateLargeWordList("hit", "zzz", 10000), 0)) passed++;

        System.out.println("\nPassed " + passed + "/" + total + " tests.");
    }

    private static boolean test(WordLadderI solver, String beginWord, String endWord, List<String> wordList, int expectedLength) {
        int result = solver.ladderLength(beginWord, endWord, wordList);
        boolean passed = result == expectedLength;
        System.out.println((passed ? "✅" : "❌") + " Test with beginWord = " + beginWord + ", endWord = " + endWord + " → Expected: " + expectedLength + ", Got: " + result);
        return passed;
    }

    private static List<String> generateLargeWordList(String beginWord, String endWord, int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add("word" + i);
        }
        list.add(endWord); // Ensure endWord is present
        return list;
    }
}
