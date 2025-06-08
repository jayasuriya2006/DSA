package dsa.greedy.test;

import dsa.greedy.main.ValidParanthesisChecker;

public class ValidParanthesisCheckerTest {

    /*
    Find the validity of an input string s that only contains the letters '(', ')' and '*'.
    A string entered is legitimate if
        Any left parenthesis '(' must have a corresponding right parenthesis ')'.
        Any right parenthesis ')' must have a corresponding left parenthesis '('.
        Left parenthesis '(' must go before the corresponding right parenthesis ')'.
        '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

    Examples:
       Input : s = (*))
       Output : true
       Explanation : The * can be replaced by an opening '(' bracket. The string after replacing the * mark is "(())" and is a valid string.

       Input : s = *(()
       Output : false
       Explanation : The * replaced with any bracket does not form a valid string.
     */

    public static void main(String[] args) {
        String expression = "(*))";
        boolean isValid = true;

        boolean actualRes_brut = ValidParanthesisChecker.isValidExpression_Brut(expression);
        if (isValid == actualRes_brut) {
            System.out.println("...........BRUT - TEST PASSED.........");
        } else {
            System.out.println("...........BRUT - TEST FAILED.........");
        }

        boolean actualRes_optimal = ValidParanthesisChecker.isValidExpression_Optimal(expression);
        if (isValid == actualRes_optimal) {
            System.out.println("...........OPTIMAL - TEST PASSED.........");
        } else {
            System.out.println("...........OPTIMAL - TEST FAILED.........");
        }

    }
}
