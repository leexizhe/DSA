package answers.c_stack;

import java.util.Arrays;

public class C6CarFleet {
    /**
     * Time Complexity: O(n log n)
     * The time complexity of this solution is O(n log n) due to the sorting step.
     * The following iteration through cars is O(n), making the overall complexity O(n log n).
     *
     * Space Complexity: O(n)
     * The space complexity of this solution is O(n) since we store position-speed pairs in an auxiliary array.
     */
    private static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        // Step 1: Store positions and times to reach target
        for (int i = 0; i < n; i++) {
            cars[i] = new double[] {position[i], (double) (target - position[i]) / speed[i]};
        }

        // Step 2: Sort cars by position (farthest to closest)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // Step 3: Count fleets using a greedy approach
        int fleets = 0;
        double lastArrival = 0;

        for (double[] car : cars) {
            double arrivalTime = car[1];
            if (arrivalTime > lastArrival) {
                fleets++;
                lastArrival = arrivalTime;
            }
        }
        return fleets;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};

        int[] position2 = {6, 2, 4};
        int[] speed2 = {3, 2, 1};

        System.out.println(carFleet(target, position1, speed1)); // Output: 3
        System.out.println(carFleet(target, position2, speed2)); // Output: 3
    }
}
