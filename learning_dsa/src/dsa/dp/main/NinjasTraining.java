package dsa.dp.main;

import java.util.Arrays;

public class NinjasTraining {

    //TC - O(N * 3 * 3)
    //SC - O(N * 3) + O(N)
    public static int getMaxPointsMemo(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        int m = points[0].length;
        int[][] dp = new int[n][m + 1];
        for (int[] day : dp) {
            Arrays.fill(day, -1);
        }
        return getMaxPointsMemoHelper(points, n - 1, 3, dp);
    }

    public static int getMaxPointsMemoHelper(int[][] points, int day, int lastTask, int[][] dp) {

        if (dp[day][lastTask] != -1) {
            return dp[day][lastTask];
        }

        if (day == 0) {
            int maxPoints = Integer.MIN_VALUE;
            for (int task = 0; task <= 2; task++) {
                if (task != lastTask) {
                    maxPoints = Math.max(maxPoints, points[0][task]);
                }
            }
            dp[day][lastTask] = maxPoints;
            return maxPoints;
        }

        int maxPoints = Integer.MIN_VALUE;
        for (int task = 0; task <= 2; task++) {
            if (task != lastTask) {
                int curDayPoints = points[day][task] + getMaxPointsMemoHelper(points, day - 1, task, dp);
                maxPoints = Math.max(maxPoints, curDayPoints);
            }
        }
        dp[day][lastTask] = maxPoints;
        return dp[day][lastTask];
    }

    //TC - O(N * 3 * 3)
    //SC - O(N * 3)
    public static int getMaxPointsTabulation(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        int m = points[0].length;
        int[][] dp = new int[n][m];

        dp[0] = points[0];
        for (int day = 1; day < n; day++) {
            for (int task = 0; task <= 2; task++) {
                int maxPoints = Integer.MIN_VALUE;
                for (int last = 0; last <= 2; last++) {
                    if (last != task) {
                        maxPoints = Math.max(maxPoints, points[day][task] + dp[day - 1][last]);
                    }
                }
                dp[day][task] = maxPoints;
            }

        }

        int maxPoints = Integer.MIN_VALUE;
        for (int task = 0; task <= 2; task++) {
            maxPoints = Math.max(maxPoints, dp[n - 1][task]);
        }

        return maxPoints;
    }

    //TC - O(N * 3 * 3)
    //SC - O(3)
    public static int getMaxPointsSpaceOptimized(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        int[] prev = new int[3];

        prev = points[0];
        for (int day = 1; day < n; day++) {
            int[] temp = new int[3];
            for (int task = 0; task <= 2; task++) {
                int maxPoints = Integer.MIN_VALUE;
                for (int last = 0; last <= 2; last++) {
                    if (last != task) {
                        maxPoints = Math.max(maxPoints, points[day][task] + prev[last]);
                    }
                }
                temp[task] = maxPoints;
            }
            prev = temp;
        }

        int maxPoints = Integer.MIN_VALUE;
        for (int task = 0; task <= 2; task++) {
            maxPoints = Math.max(maxPoints, prev[task]);
        }

        return maxPoints;
    }

}
