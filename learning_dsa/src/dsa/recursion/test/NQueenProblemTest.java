package dsa.recursion.test;

import dsa.recursion.main.AllPermutationsOne;
import dsa.recursion.main.NQueenProblem;

import java.util.List;

public class NQueenProblemTest {

    public static void main(String[] args) {
        int n = 4;

        //only one solution will give, we can remove boolean return for getting all possible solution
        List<List<String>> ans = NQueenProblem.solveNQueens(n);

        for (List<String> row : ans) {
            System.out.println(row);
        }
    }
}
