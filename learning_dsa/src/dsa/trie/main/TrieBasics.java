package dsa.trie.main;

public class TrieBasics {

    private TrieNode root;

    public TrieBasics() {
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
    public boolean searchWord(String word) {
        TrieNode node = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                return false;
            }
            node = node.getNode(word.charAt(i));
        }
        return node.isEnd();
    }

    //TC - O(len(word))
    public boolean startWith(String word) {
        TrieNode node = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsNode(word.charAt(i))) {
                return false;
            }
            node = node.getNode(word.charAt(i));
        }
        return true;
    }

    //TC - O(len(word))
    public boolean isCompleteWord(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsNode(word.charAt(i))) {
                node = node.getNode(word.charAt(i));
            } else {
                return false;
            }

            if (!node.isEnd()) {
                return false;
            }
        }
        return node.isEnd();
    }


}

class TrieNode {

    private TrieNode[] links;
    private boolean isEnd;

    TrieNode() {
        this.links = new TrieNode[26];
        this.isEnd = false;
    }

    public boolean containsNode(char c) {
        return this.links[c - 'a'] != null;
    }

    public void putNode(char c, TrieNode newNode) {
        this.links[c - 'a'] = newNode;
    }

    public TrieNode getNode(char c) {
        return this.links[c - 'a'];
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void setEnd(boolean end) {
        this.isEnd = end;
    }

}
