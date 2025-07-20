package dsa.stackqueue.test;

import static dsa.stackqueue.main.validParenthesis.isValidParenthesis;

public class validParenthesisTest {
    public static void main(String[] args) {
        /*
          ("{[()]}", True),
          ("([)]", False),
          ("({[<>]})", True),
          ("(]", False),
          ("((()))", True)
         */
        String exp = "((()))";
        boolean isValid = isValidParenthesis(exp);
        System.out.println(isValid);
    }
}
