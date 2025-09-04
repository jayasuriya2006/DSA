package dsa.graphs.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Create adjacency list
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int[] flight : flights) {
            List<Integer> ad = new ArrayList<>();
            ad.add(flight[1]); // Destination city
            ad.add(flight[2]); // Cost of the flight
            adj.get(flight[0]).add(ad);
        }

        // BFS Queue
        Queue<CityInfo> queue = new LinkedList<>();
        queue.add(new CityInfo(src, 0, 0)); // Start from source city
        dist[src] = 0;
        int minCost = Integer.MAX_VALUE;

        // BFS Traversal
        //int leval = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            CityInfo current = queue.poll();
            int currentCity = current.city;
            int currentCost = current.cost;
            int stops = current.stop;

            // Stop traversal if we exceed allowed stops
            if (stops > k) continue;

            // Traverse all neighboring cities
            for (List<Integer> neighbor : adj.get(currentCity)) {
                int nextCity = neighbor.get(0);
                int nextCost = neighbor.get(1);
                if (currentCost + nextCost < dist[nextCity] && stops <= k) {
                    // Add the next city to the queue with updated cost and stops
                    dist[nextCity] = currentCost + nextCost;
                    queue.add(new CityInfo(nextCity, currentCost + nextCost, stops + 1));
                }
            }
        }

        if (dist[dst] != Integer.MAX_VALUE) return dist[dst];
        return -1;
    }
}

class CityInfo {
    int city;
    int cost;
    int stop;

    public CityInfo(int city, int cost, int stop) {
        this.city = city;
        this.cost = cost;
        this.stop = stop;
    }
}
