package dsa.greedy.main;

public class JumpGameII {

    //TC - O(N^N)
    //SC - O(N)
    //if we use DP then TC - O(N ^ 2) SC - O(N^2)
    public static int getMinJumps_Brut(int[] jumps) {
        return getMinJumps(jumps, 0, 0);
    }

    private static int getMinJumps(int[] jumps, int currentInd, int jump) {
        if (currentInd >= jumps.length - 1) {
            return jump;
        }
        int minJump = Integer.MAX_VALUE;
        for (int i = 1; i <= jumps[currentInd]; i++) {
            minJump = Math.min(minJump, getMinJumps(jumps, currentInd + i, jump + 1));
        }
        return minJump;
    }

    //window approach
    //TC - O(N)
    //SC - (1)
    public static int getMinJumps_Optimal(int[] jumps) {
        int jump = 0;
        int left = 0;
        int right = 0;
        int n = jumps.length;
        while (right < n - 1) {
            int maxOfWindow = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                maxOfWindow = Math.max(maxOfWindow, jumps[i] + i);
            }
            jump++;
            //till this window i can reach from previous window
            left = right + 1;
            right = maxOfWindow;
        }
        return jump;
    }

}
