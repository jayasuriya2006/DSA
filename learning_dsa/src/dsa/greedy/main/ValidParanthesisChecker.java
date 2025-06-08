package dsa.greedy.main;

public class ValidParanthesisChecker {

    //Using recursion
    //3 branches,
    //TC - O(3 ^ N)
    //SC - O(N)
    // We can use DP, TC - O(N^2)
    //SC - O(N^2)
    public static boolean isValidExpression_Brut(String expression) {
        return isValidExpression_Brut(expression, 0, 0);
    }

    private static boolean isValidExpression_Brut(String expression, int index, int count) {
        //if count < 0 means no corresponding opening bracket
        if (index == expression.length()) {
            return count == 0;
        } else if (count < 0) {
            return false;
        }

        if (expression.charAt(index) == '(') {
            return isValidExpression_Brut(expression, index + 1, count + 1);
        } else if (expression.charAt(index) == ')') {
            return isValidExpression_Brut(expression, index + 1, count - 1);
        } else {
            // if * ,3 possibilities, consider as ( or consider as ) or consider as empty
            return isValidExpression_Brut(expression, index + 1, count + 1) ||
                    isValidExpression_Brut(expression, index + 1, count - 1) ||
                    isValidExpression_Brut(expression, index + 1, count);
        }
    }

    //Using max and min range
    //TC - O(N)
    //SC - O(1)
    public static boolean isValidExpression_Optimal(String expression) {
        int min = 0;
        int max = 0;

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                min++;
                max++;
            } else if (expression.charAt(i) == ')') {
                min--;
                max--;
            } else {
                //considering )
                min--;
                //considering (
                max++;
            }
            if (min < 0) min = 0;
            if (max < 0) return false;
        }
        return min == 0;
    }
}
