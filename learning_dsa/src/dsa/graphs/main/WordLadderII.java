package dsa.graphs.main;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        beginWord = beginWord.toLowerCase();
        endWord = endWord.toLowerCase();

        // Handle special case: begin == end
        if (beginWord.equals(endWord)) {
            List<List<String>> single = new ArrayList<>();
            //single.add(Collections.singletonList(beginWord));
            return single;
        }

        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word.toLowerCase());
        }

        Queue<List<String>> que = new LinkedList<>();
        List<List<String>> ans = new ArrayList<>();
        //Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return ans;

        que.offer(new ArrayList<>(List.of(beginWord)));

        Set<String> visited = new HashSet<>();
        Set<String> currentLevelVisited = new HashSet<>();

        int level = 1;
        int shortest = Integer.MAX_VALUE;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int s = 0; s < size; s++) {
                List<String> path = que.poll();
                String lastWord = path.get(path.size() - 1);

                if (path.size() > level) {
                    // Remove all visited words of previous level
                    wordSet.removeAll(currentLevelVisited);
                    currentLevelVisited.clear();
                    level = path.size();

                    if (level > shortest) {
                        break;  // No need to explore longer paths
                    }
                }

                if (lastWord.equals(endWord)) {
                    if (path.size() <= shortest) {
                        shortest = path.size();
                        ans.add(new ArrayList<>(path));
                    }
                    continue;
                }

                char[] chArr = lastWord.toCharArray();
                for (int i = 0; i < chArr.length; i++) {
                    char original = chArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chArr[i] = c;
                        String nextWord = new String(chArr);
                        if (wordSet.contains(nextWord)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(nextWord);
                            que.offer(newPath);
                            currentLevelVisited.add(nextWord);
                        }
                    }
                    chArr[i] = original;
                }
            }
        }
        return ans;
    }
}
