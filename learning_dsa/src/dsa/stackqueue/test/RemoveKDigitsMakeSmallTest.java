package dsa.stackqueue.test;

import static dsa.stackqueue.main.RemoveKDigitsMakeSmall.removeKDigitsMakeSmallNumber;

public class RemoveKDigitsMakeSmallTest {
    public static void main(String[] args) {

        String[] testNums = {
                "1432219",
                "10200",
                "10",
                "9",
                "1234567890",
                "10001",
                "100200300",
                "112",
                "1111111",
                "1000000"
        };

        int[] testKs = {
                3,
                1,
                2,
                1,
                9,
                1,
                4,
                1,
                3,
                1
        };

        String[] expectedOutputs = {
                "1219",
                "200",
                "0",
                "0",
                "0",
                "1",
                "0",
                "11",
                "1111",
                "0"
        };

        for (int i = 0; i < testNums.length; i++) {
            String result = removeKDigitsMakeSmallNumber(testNums[i], testKs[i]);
            System.out.println("Test case " + (i + 1));
            System.out.println("Input:    num = \"" + testNums[i] + "\", k = " + testKs[i]);
            System.out.println("Expected: \"" + expectedOutputs[i] + "\"");
            System.out.println("Actual:   \"" + result + "\"");
            System.out.println(result.equals(expectedOutputs[i]) ? "✅ Passed" : "❌ Failed");
            System.out.println("-----------");
        }
    }
}
