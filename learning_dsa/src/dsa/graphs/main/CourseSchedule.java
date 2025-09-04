package dsa.graphs.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> topo = getTopologicalSort(prerequisites, numCourses);
        return topo.size() == numCourses;
    }

    private List<Integer> getTopologicalSort(int[][] prerequisites, int numCourses) {
        List<Integer> topoSort = new ArrayList<>();
        int[] indegree = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build adj list and indegree array in one pass
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adjList.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            topoSort.add(current);
            for (int neighbor : adjList.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return topoSort;
    }
}
