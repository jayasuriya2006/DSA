package dsa.trie.main;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestion {
    public List<String> getSuggestionsForSearchWord(String[] keyWords, String searchWord) {
        TrieSuggestion helper = new TrieSuggestion();

        for (String word : keyWords) {
            helper.insertWord(word);
        }

        return helper.getSuggestions(searchWord);
    }
}

class TrieSuggestion {

    private TrieNode root;

    public TrieSuggestion() {
        this.root = new TrieNode();
    }

    //TC - O(len(word))
    public void insertWord(String word) {
        TrieNode node = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                node.putNode(word.charAt(i), new TrieNode());
            }
            node = node.getNode(word.charAt(i));
        }
        node.setEnd(true);
    }

    //TC - O(len(word))
    public List<String> getSuggestions(String word) {
        TrieNode node = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                return new ArrayList<>();
            }
            node = node.getNode(word.charAt(i));
        }

        List<String> suggestions = new ArrayList<>();
        dfs(node, suggestions, new StringBuilder(word));
        return suggestions;
    }

    private void dfs(TrieNode node, List<String> suggestions, StringBuilder word) {
        if (node == null) return;

        if (node.isEnd()) {
            suggestions.add(word.toString());
        }

        for (char i = 'a'; i <= 'z'; i++) {
            if (node.containsNode(i)) {
                word.append(i);
                dfs(node.getNode(i), suggestions, word);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }
}


