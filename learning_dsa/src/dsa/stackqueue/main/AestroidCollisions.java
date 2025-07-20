package dsa.stackqueue.main;

import java.util.ArrayDeque;
import java.util.Deque;

public class AestroidCollisions {

    public static int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                int absAsteroid = Math.abs(asteroid);
                while (!stack.isEmpty() && stack.peek() > 0 && absAsteroid > stack.peek()) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() > 0 && absAsteroid == stack.peek()) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
