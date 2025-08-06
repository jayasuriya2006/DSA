package dsa.trie.main;

public class MaxXORBetweenTwoArrays {

    //TC - O( n * 32) + O(m * 32)
    public int getMaxXorBetweenTwoArrays(int[] arr1, int[] arr2) {

        if (arr1.length == 0 || arr2.length == 0) return 0;

        TrieMaxXor trie = new TrieMaxXor();
        for (int num : arr1) {
            trie.insertNumber(num);
        }

        int maxXOR = 0;
        for (int num : arr2) {
            int xor = trie.getMaxXor(num);
            maxXOR = Math.max(maxXOR, xor);
        }

        return maxXOR;
    }
}


class TrieMaxXor {
    TrieNodeBinary root;

    public TrieMaxXor() {
        this.root = new TrieNodeBinary();
    }

    public void insertNumber(int num) {
        TrieNodeBinary node = this.root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new TrieNodeBinary());
            }
            node = node.get(bit);
        }
    }

    public int getMaxXor(int num) {
        TrieNodeBinary node = this.root;
        int maxXOR = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxXOR = (1 << i) | maxXOR;
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxXOR;
    }
}

class TrieNodeBinary {

    TrieNodeBinary[] links;

    TrieNodeBinary() {
        this.links = new TrieNodeBinary[2];
    }

    public boolean containsKey(int bit) {
        return this.links[bit] != null;
    }

    public void put(int bit, TrieNodeBinary newNode) {
        this.links[bit] = newNode;
    }

    public TrieNodeBinary get(int bit) {
        return this.links[bit];
    }

}
