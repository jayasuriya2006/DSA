package dsa.trie.test;

import dsa.trie.main.SearchSuggestion;

import java.util.List;

public class SearchSuggestionTest {
    public static void main(String[] args) {
        SearchSuggestion system = new SearchSuggestion();

        String[] keyWords = {"mobile", "mouse", "moneypot", "monitor", "mousepad", "moab", "moaa"};
        String searchWord = "moa";

        List<String> suggestions = system.getSuggestionsForSearchWord(keyWords, searchWord);
        System.out.println("Suggestions for \"" + searchWord + "\": " + suggestions);
        // Output: [mouse, mousepad]
    }
}
