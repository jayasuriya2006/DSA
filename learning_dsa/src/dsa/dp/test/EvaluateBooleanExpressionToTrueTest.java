package dsa.dp.test;

import dsa.dp.main.EvaluateBooleanExpressionToTrue;

public class EvaluateBooleanExpressionToTrueTest {
    public static void main(String[] args) {
        runTest("T|F", 1);
        runTest("T^F|F", 2);
        runTest("T^F|F&T", 5);
        runTest("T|T&F^T", 4);
        runTest("T", 1);
        runTest("F", 0);
        runTest("T&T", 1);
        runTest("F|F", 0);
        runTest("T|F&T^T|F", 7);          // Moderate length
        runTest("T^T^T^T", 0);            // Alternating XOR chain
        runTest("T|T|T|T", 5);            // All ORs, result should be 5
        runTest("T&T&T&T", 5);            // All ANDs, only one way
        runTest("F^F^F^F", 0);            // All Falses with XOR
        runTest("T|F&T^T|F&T^T", 83);     // Mix of all, medium-long
    }

    private static void runTest(String exp, int expected) {
        System.out.println("Expression: " + exp);

        int result = EvaluateBooleanExpressionToTrue.getNoOfWaysForTrue(exp);
        System.out.println("Result             : " + result);
        System.out.println("Expected           : " + expected);
        System.out.println(result == expected ? "✅ Test Passed" : "❌ Test Failed");
        System.out.println("--------------------------------------------------");
    }
}
