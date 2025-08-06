package dsa.trie.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxXORQueries {


    /**
     * Answers each query [x, a] with the maximum XOR of x with any number y in arr such that y <= a.
     * If no such y exists, return -1 for that query.
     *
     * @param queries - array of queries, each query is [x, a]
     * @param arr     - array of integers
     * @return array of answers for each query
     */
    public int[] maxXorQueries(int[][] queries, int[] arr) {
        // Sort the array for incremental insertion into trie
        //O(N logN)
        Arrays.sort(arr);

        // Create a list of queries with index for mapping answers
        List<QueryInfo> qList = new ArrayList<>();
        int qCount = queries.length;
        for (int i = 0; i < qCount; i++) {
            qList.add(new QueryInfo(queries[i][0], queries[i][1], i));
        }

        // Sort queries based on conditionNum (i.e., max allowable value in arr)
        //O(Q logQ)
        Collections.sort(qList, (a, b) -> a.conditionNum - b.conditionNum);

        // Initialize result array
        int[] result = new int[qCount];

        TrieMaxXor trie = new TrieMaxXor();
        int curIndex = 0;

        // Process queries in order of increasing conditionNum
        //O(Q)
        for (QueryInfo query : qList) {
            int num = query.num;
            int conditionNum = query.conditionNum;
            int index = query.index;

            // Insert arr values <= conditionNum into trie
            //O(N) * 32
            while (curIndex < arr.length && arr[curIndex] <= conditionNum) {
                trie.insertNumber(arr[curIndex]);
                curIndex++;
            }

            // If no valid arr values, return -1
            if (curIndex == 0) {
                result[index] = -1;
            } else {
                //O(Q * 32)
                result[index] = trie.getMaxXor(num);
            }
        }

        return result;
    }
}

class QueryInfo {
    int num;
    int conditionNum;
    int index;

    public QueryInfo(int num, int conditionNum, int index) {
        this.num = num;
        this.conditionNum = conditionNum;
        this.index = index;
    }
}
