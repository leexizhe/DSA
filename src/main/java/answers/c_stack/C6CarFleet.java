package answers.c_stack;

import java.util.Arrays;

public class C6CarFleet {

    /**
     * Key Techniques:
     * ✅ Sorting → Ensures cars are processed in descending order.
     * ✅ Stack Simulation → Tracks fleets dynamically.
     * ✅ O(n log n) Time Complexity → Sorting dominates runtime.
     *
     * Time Complexity: O(n log n)
     * Sorting the positions ensures efficient fleet processing.
     *
     * Space Complexity: O(n)
     * Stores all fleet time calculations.
     */
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        double[][] cars = new double[n][2]; // Store position and time to reach target
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // Sort by position descending

        int fleets = 0;
        double lastFleetTime = 0;

        // Step 1: Traverse sorted cars and form fleets
        for (double[] car : cars) {
            double time = car[1];
            if (time > lastFleetTime) {
                fleets++;
                lastFleetTime = time; // New fleet begins
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
