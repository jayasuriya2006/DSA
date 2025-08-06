package dsa.trie.test;

import dsa.trie.main.TrieProblem;

public class TrieProblemTest {

    public static void main(String[] args) {

        TrieProblem trie = new TrieProblem();

        // Insert words
        trie.insertWord("apple");
        trie.insertWord("app");
        trie.insertWord("application");
        trie.insertWord("app");
        trie.insertWord("bat");
        trie.insertWord("batch");
        trie.insertWord("bat");

        // Search words
        System.out.println("Search 'apple': " + (trie.searchWord("apple") == true ? "PASS" : "FAIL"));   // true
        System.out.println("Search 'app': " + (trie.searchWord("app") == true ? "PASS" : "FAIL"));       // true
        System.out.println("Search 'appl': " + (trie.searchWord("appl") == false ? "PASS" : "FAIL"));     // false
        System.out.println("Search 'bat': " + (trie.searchWord("bat") == true ? "PASS" : "FAIL"));       // true
        System.out.println("Search 'bath': " + (trie.searchWord("bath") == false ? "PASS" : "FAIL"));     // false

        // Word count
        System.out.println("Word count 'app': " + (trie.wordCount("app") == 2 ? "PASS" : "FAIL"));        // 2
        System.out.println("Word count 'apple': " + (trie.wordCount("apple") == 1 ? "PASS" : "FAIL"));    // 1
        System.out.println("Word count 'bat': " + (trie.wordCount("bat") == 2 ? "PASS" : "FAIL"));        // 2

        // Prefix count
        System.out.println("StartWith 'app': " + (trie.startWithCount("app") == 4 ? "PASS" : "FAIL"));    // 4 -> app, apple, app, application
        System.out.println("StartWith 'bat': " + (trie.startWithCount("bat") == 3 ? "PASS" : "FAIL"));    // 3 -> bat, batch, bat
        System.out.println("StartWith 'ba': " + (trie.startWithCount("ba") == 3 ? "PASS" : "FAIL"));      // 3

        // Delete word
        trie.deleteWord("app");
        System.out.println("After deleting 'app' once:");
        System.out.println("Word count 'app': " + (trie.wordCount("app") == 1 ? "PASS" : "FAIL"));        // 1
        System.out.println("StartWith 'app': " + (trie.startWithCount("app") == 3 ? "PASS" : "FAIL"));    // 3

        trie.deleteWord("app");
        System.out.println("After deleting 'app' twice:");
        System.out.println("Word count 'app': " + (trie.wordCount("app") == 0 ? "PASS" : "FAIL"));        // 0
        System.out.println("Search 'app': " + (trie.searchWord("app") == false ? "PASS" : "FAIL"));      // false
        System.out.println("StartWith 'app': " + (trie.startWithCount("app") == 2 ? "PASS" : "FAIL"));    // apple, application

    }
}
