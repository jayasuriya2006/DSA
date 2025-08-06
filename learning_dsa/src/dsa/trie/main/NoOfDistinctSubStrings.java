package dsa.trie.main;

import java.util.HashSet;
import java.util.Set;

public class NoOfDistinctSubStrings {

    //TC - O(N ^ 2)
    //SC - O(No of distinct sub strings)
    public int getNoOfDistinctSubStringsUsingSet(String word) {

        int len = word.length();
        Set<String> distinctSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            String subString = "";
            for (int j = i; j < len; j++) {
                subString = subString + word.charAt(j);
                distinctSet.add(subString);
            }
        }
        return distinctSet.size();
    }

    //TC - O(N ^ 2)
    public int getNoOfDistinctSubStringsUsingTrie(String word) {
        int count = 0;
        int len = word.length();
        Trie trie = new Trie();
        for (int i = 0; i < len; i++) {
            String subString = "";
            for (int j = i; j < len; j++) {
                subString = subString + word.charAt(j);
                count += trie.insertWord(subString);
            }
        }
        return count;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    //TC - O(len(word))
    public int insertWord(String word) {
        int count = 0;
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                node.putNode(word.charAt(i), new TrieNode());
                count++;
            }
            node = node.getNode(word.charAt(i));
        }

        return count;
    }

}
