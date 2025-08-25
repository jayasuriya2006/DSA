package dsa.graphs.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

    public String findOrder(String[] words) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[26];
        boolean[] present = new boolean[26]; // Track used characters

        // Mark all characters that appear in any word
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // ❗ Invalid if w1 is longer and w1 starts with w2
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int minLen = Math.min(w1.length(), w2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    indegree[c2 - 'a']++;
                    break;
                }
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                que.offer(i);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!que.isEmpty()) {
            int cur = que.poll();
            res.append((char) (cur + 'a'));
            for (int nei : adj.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    que.offer(nei);
                }
            }
        }

        // Check for cycle — if topo doesn't include all characters
        int totalChars = 0;
        for (boolean b : present) {
            if (b) totalChars++;
        }

        if (res.length() != totalChars) {
            return ""; // Cycle detected
        }

        return res.toString();
    }
}
