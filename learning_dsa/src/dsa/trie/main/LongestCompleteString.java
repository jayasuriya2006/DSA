package dsa.trie.main;

public class LongestCompleteString {


    //TC - O(n * word(len))
    public String getLongestCommonString(String[] words) {
        TrieBasics trieObject = new TrieBasics();
        for (String word : words) {
            trieObject.insertWord(word);
        }

        String longestCommonString = "";
        for (String word : words) {
            if (trieObject.isCompleteWord(word)) {
                if (longestCommonString.length() < word.length()) {
                    longestCommonString = word;
                } else if (longestCommonString.length() == word.length()) {
                    longestCommonString = longestCommonString.compareTo(word) < 0 ? longestCommonString : word;
                }
            }
        }
        return longestCommonString;
    }
}
