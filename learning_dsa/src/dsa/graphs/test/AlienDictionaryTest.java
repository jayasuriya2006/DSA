package dsa.graphs.test;

import dsa.graphs.main.AlienDictionary;

public class AlienDictionaryTest {
    public static void main(String[] args) {
        AlienDictionary alienDict = new AlienDictionary();

        int passed = 0, total = 10;

        passed += runTest(alienDict, new String[]{"baa", "abcd", "abca", "cab", "cad"}, true, "Test1");
        passed += runTest(alienDict, new String[]{"caa", "aaa", "aab"}, true, "Test2");
        passed += runTest(alienDict, new String[]{"ab", "cd", "ef", "ad"}, false, "Test3");
        passed += runTest(alienDict, new String[]{"abc", "ab"}, false, "Test4");
        passed += runTest(alienDict, new String[]{"z"}, true, "Test5");
        passed += runTest(alienDict, new String[]{"a", "b", "c"}, true, "Test6");
        passed += runTest(alienDict, new String[]{"wrt", "wrf", "er", "ett", "rftt"}, true, "Test7");
        passed += runTest(alienDict, new String[]{"z", "x"}, true, "Test8");
        passed += runTest(alienDict, new String[]{"z", "x", "z"}, false, "Test9"); // cycle
        passed += runTest(alienDict, new String[]{"abc", "abx", "ab"}, false, "Test10"); // prefix invalid

        System.out.println("\nPassed " + passed + " out of " + total + " tests.");
    }

    private static int runTest(AlienDictionary alienDict, String[] words, boolean expectValid, String testName) {
        String order = alienDict.findOrder(words);
        boolean actualValid = (order != null && !order.isEmpty()) && isValidOrder(words, order);

        // if expected invalid, actualValid must be false or order empty
        boolean passed = (expectValid && actualValid) || (!expectValid && (order == null || order.isEmpty() || !actualValid));

        if (passed) {
            System.out.println(testName + ": ✅");
            return 1;
        } else {
            System.out.println(testName + ": ❌");
            System.out.println("  Words: " + java.util.Arrays.toString(words));
            System.out.println("  Returned order: '" + order + "'");
            return 0;
        }
    }

    private static boolean isValidOrder(String[] words, String order) {
        if (order == null || order.isEmpty()) return false;
        int[] pos = new int[26];
        for (int i = 0; i < order.length(); i++) {
            pos[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            boolean diffFound = false;
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (pos[w1.charAt(j) - 'a'] > pos[w2.charAt(j) - 'a']) {
                        return false;
                    }
                    diffFound = true;
                    break;
                }
            }
            if (!diffFound && w1.length() > w2.length()) {
                return false;
            }
        }
        return true;
    }
}
