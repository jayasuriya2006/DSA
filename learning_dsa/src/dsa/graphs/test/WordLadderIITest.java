package dsa.graphs.test;

import dsa.graphs.main.WordLadderII;

import java.util.*;

public class WordLadderIITest {
    public static void main(String[] args) {
        WordLadderII solver = new WordLadderII();

        int passed = 0;
        int total = 10;

        // Test Case 1: Basic Test
        if (test(solver, "hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"),
                Arrays.asList(
                        Arrays.asList("hit","hot","dot","dog","cog"),
                        Arrays.asList("hit","hot","lot","log","cog")
                ))) passed++;

        // Test Case 2: No path
        if (test(solver, "hit", "cog", Arrays.asList("hot","dot","dog","lot","log"),
                Collections.emptyList())) passed++;

        // Test Case 3: Begin == End
        if (test(solver, "hit", "hit", Arrays.asList("hit"),
                Collections.emptyList())) passed++;

        // Test Case 4: Direct connection
        if (test(solver, "a", "c", Arrays.asList("a", "b", "c"),
                Arrays.asList(
                        Arrays.asList("a","c")
                ))) passed++;

        // Test Case 5: Multiple shortest paths
        if (test(solver, "red", "tax", Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"),
                Arrays.asList(
                        Arrays.asList("red","ted","tad","tax"),
                        Arrays.asList("red","ted","tex","tax"),
                        Arrays.asList("red","rex","tex","tax")
                ))) passed++;

        // Test Case 6: End word not in list
        if (test(solver, "hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cot"),
                Collections.emptyList())) passed++;

        // Test Case 7: Long single path
        if (test(solver, "hit", "xyz", Arrays.asList("hot","dot","dog","lot","log","cog","xoz","xoy","xoz","xyz"),
                Collections.emptyList())) passed++;

        // Test Case 8: Case sensitivity (should treat as lowercase)
        if (test(solver, "Hit", "Cog", Arrays.asList("hot","dot","dog","lot","log","cog"),
                Arrays.asList(
                        Arrays.asList("hit","hot","dot","dog","cog"),
                        Arrays.asList("hit","hot","lot","log","cog")
                ))) passed++;

        // Test Case 9: Word list has duplicates
        if (test(solver, "hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog","cog","dog"),
                Arrays.asList(
                        Arrays.asList("hit","hot","dot","dog","cog"),
                        Arrays.asList("hit","hot","lot","log","cog")
                ))) passed++;

        // Test Case 10: Large input with no valid transformation
        if (test(solver, "aaa", "zzz", generateLargeWordList("aaa", "zzz", 10000),
                Collections.emptyList())) passed++;

        System.out.println("\nPassed " + passed + "/" + total + " tests.");
    }

    private static boolean test(WordLadderII solver, String beginWord, String endWord, List<String> wordList, List<List<String>> expected) {
        List<List<String>> result = solver.findLadders(beginWord.toLowerCase(), endWord.toLowerCase(), toLowerCaseList(wordList));
        Set<List<String>> resultSet = new HashSet<>(result);
        Set<List<String>> expectedSet = new HashSet<>(expected);
        boolean passed = resultSet.equals(expectedSet);
        System.out.println((passed ? "✅" : "❌") + " Test with beginWord = " + beginWord + ", endWord = " + endWord);
        return passed;
    }

    private static List<String> toLowerCaseList(List<String> list) {
        List<String> lowered = new ArrayList<>();
        for (String s : list) {
            lowered.add(s.toLowerCase());
        }
        return lowered;
    }

    private static List<String> generateLargeWordList(String beginWord, String endWord, int count) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            words.add("word" + i);
        }
        words.add(endWord); // Ensure endWord is there
        return words;
    }
}
