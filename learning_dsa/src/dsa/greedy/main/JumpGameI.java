package dsa.greedy.main;

public class JumpGameI {

    //TC - O(N)
    //SC - O(1)
    public static boolean canReachLast(int[] jumps) {
        int n = jumps.length;
        int maxReached = 0;
        for (int i = 0; i < n; i++) {
            //if not reached index i
            if (i > maxReached) {
                return false;
            }
            maxReached = Math.max(maxReached, i + jumps[i]);
        }
        return true;
    }
}
