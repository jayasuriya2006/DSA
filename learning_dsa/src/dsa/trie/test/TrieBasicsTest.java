package dsa.trie.test;

import dsa.trie.main.TrieBasics;

public class TrieBasicsTest {
    public static void main(String[] args) {

        TrieBasics trie = new TrieBasics();

        // Insert words
        trie.insertWord("apple");
        trie.insertWord("app");
        trie.insertWord("application");
        trie.insertWord("banana");

        // Test searchWord
        System.out.println("Search 'apple': " + (trie.searchWord("apple") == true ? "PASS" : "FAIL"));     // true
        System.out.println("Search 'app': " + (trie.searchWord("app") == true ? "PASS" : "FAIL"));         // true
        System.out.println("Search 'appl': " + (trie.searchWord("appl") == false ? "PASS" : "FAIL"));       // false
        System.out.println("Search 'banana': " + (trie.searchWord("banana") == true ? "PASS" : "FAIL"));   // true
        System.out.println("Search 'ban': " + (trie.searchWord("ban") == false ? "PASS" : "FAIL"));         // false

        // Test startWith
        System.out.println("StartWith 'app': " + (trie.startWith("app") == true ? "PASS" : "FAIL"));       // true
        System.out.println("StartWith 'appl': " + (trie.startWith("appl") == true ? "PASS" : "FAIL"));     // true
        System.out.println("StartWith 'ban': " + (trie.startWith("ban") == true ? "PASS" : "FAIL"));       // true
        System.out.println("StartWith 'bana': " + (trie.startWith("bana") == true ? "PASS" : "FAIL"));     // true
        System.out.println("StartWith 'cat': " + (trie.startWith("cat") == false ? "PASS" : "FAIL"));      // false

    }
}
