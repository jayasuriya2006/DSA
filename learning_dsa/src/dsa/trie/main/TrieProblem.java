package dsa.trie.main;

public class TrieProblem {

    TrieNodeWithCount root;

    public TrieProblem() {
        this.root = new TrieNodeWithCount();
    }

    //TC -  O(len(word))
    public void insertWord(String word) {
        TrieNodeWithCount node = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                node.putNode(word.charAt(i), new TrieNodeWithCount());
            }
            node = node.getNode(word.charAt(i));
            node.increasePrefixCount();
        }
        node.increaseEndCount();
    }

    //TC - O(len(word))
    public boolean searchWord(String word) {
        TrieNodeWithCount node = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                return false;
            }
            node = node.getNode(word.charAt(i));
        }
        return node.getEndsCount() > 0;
    }


    //TC - O (len(word))
    public void deleteWord(String word) {
        TrieNodeWithCount node = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                return;
            }
            node = node.getNode(word.charAt(i));
            node.decreasePrefixCount();
        }
        node.decreaseEndCount();
    }

    //TC - O (len(word))
    public int startWithCount(String word) {
        TrieNodeWithCount node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                return 0;
            }
            node = node.getNode(word.charAt(i));
        }
        return node.getPrefixCount();
    }

    //TC - O (len(word))
    public int wordCount(String word) {
        TrieNodeWithCount node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                return 0;
            }
            node = node.getNode(word.charAt(i));
        }
        return node.getEndsCount();
    }

}


class TrieNodeWithCount {

    private TrieNodeWithCount[] links;
    private int endsCount;
    private int prefixCount;

    TrieNodeWithCount() {
        this.links = new TrieNodeWithCount[26];
    }

    public boolean containsNode(char c) {
        return this.links[c - 'a'] != null;
    }

    public void putNode(char c, TrieNodeWithCount newNode) {
        this.links[c - 'a'] = newNode;
    }

    public TrieNodeWithCount getNode(char c) {
        return this.links[c - 'a'];
    }

    public void increaseEndCount() {
        this.endsCount++;
    }

    public void decreaseEndCount() {
        this.endsCount--;
    }

    public void increasePrefixCount() {
        this.prefixCount++;
    }

    public void decreasePrefixCount() {
        this.prefixCount--;
    }

    public int getEndsCount() {
        return this.endsCount;
    }

    public int getPrefixCount() {
        return this.prefixCount;
    }

}