package dsa.greedy.test;

import dsa.greedy.main.JumpGameII;

public class JumpGameIITest {

    /*
    Refer JumpGameITest and tell me that how many minimum jumps required to reach last index. Here guarantee than you can reach last index

    Example:
      input: {2, 3, 1, 4, 1, 1, 2}
      output: 3
      explanation: from 0 -> 1 to 2 we can reach with jump 1
                   from (1 to 2) -> we can reach 3 to 4 with jump 2
                   from (3 to 4) -> 6 we can reach with jump 3

      input: {2, 3, 1, 1, 4}
      output: 2
     */

    public static void main(String[] args) {
        int[] jumps = {2, 3, 1, 4, 1, 1, 2};
        int expectedJumps = 3;

        int actualJumps = JumpGameII.getMinJumps_Brut(jumps);
        if (actualJumps == expectedJumps) {
            System.out.println("...........BRUT - TEST PASSED.............");
        } else {
            System.out.println("...........BRUT - TEST FAILED.............");
        }

        int actualJumpsOptimal = JumpGameII.getMinJumps_Optimal(jumps);
        if (actualJumpsOptimal == expectedJumps) {
            System.out.println("...........OPTIMAL - TEST PASSED.............");
        } else {
            System.out.println("...........OPTIMAL - TEST FAILED.............");
        }

    }
}
