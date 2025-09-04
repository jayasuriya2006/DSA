package dsa.graphs.main;

import java.util.*;

public class WordLadderI {

    //TC - O(no of words * wordLen * 26)
    //SC - O(No of words)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<WordLadderTrack> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.add(new WordLadderTrack(beginWord, path));
        Set<String> set = new HashSet<>(wordList); // Initialize directly from the list

        while (!queue.isEmpty()) {
            WordLadderTrack curPos = queue.poll();
            String curString = curPos.word;

            if (curString.equals(endWord)) {
                return curPos.path.size();
            }

            for (int i = 0; i < curString.length(); i++) {
                char[] charArray = curString.toCharArray(); // Convert to char array for faster replacement
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String modifiedStr = new String(charArray);

                    if (set.contains(modifiedStr)) {
                        set.remove(modifiedStr); // Mark as visited by removing it

                        // Create a new path list to avoid modifying the original
                        List<String> cPath = new ArrayList<>(curPos.path);
                        cPath.add(modifiedStr);

                        queue.add(new WordLadderTrack(modifiedStr, cPath));
                    }
                }
            }
        }

        return 0; // If no path is found
    }
}

class WordLadderTrack {
    String word;
    List<String> path;

    public WordLadderTrack(String word, List<String> path) {
        this.word = word;
        this.path = path;
    }
}

