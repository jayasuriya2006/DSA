package dsa.graphs.test;

import dsa.graphs.main.CourseSchedule;

public class CourseScheduleTest {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();

        test(cs, 2, new int[][]{{1, 0}}, true, 1); // No cycle
        test(cs, 2, new int[][]{{1, 0}, {0, 1}}, false, 2); // Cycle
        test(cs, 4, new int[][]{{1, 0}, {2, 1}, {3, 2}}, true, 3); // Linear order
        test(cs, 4, new int[][]{{1, 0}, {2, 1}, {3, 2}, {1, 3}}, false, 4); // Cycle
        test(cs, 1, new int[][]{}, true, 5); // One course, no prereqs
        test(cs, 3, new int[][]{{1, 0}, {2, 1}}, true, 6); // All acyclic
        test(cs, 3, new int[][]{{1, 0}, {2, 1}, {0, 2}}, false, 7); // Full cycle
    }

    private static void test(CourseSchedule cs, int numCourses, int[][] prerequisites, boolean expected, int testCase) {
        boolean result = cs.canFinish(numCourses, prerequisites);
        if (result == expected) {
            System.out.println("✅ Test case " + testCase + " passed.");
        } else {
            System.out.println("❌ Test case " + testCase + " failed. Expected: " + expected + ", Got: " + result);
        }
    }
}
