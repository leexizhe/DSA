package answers.arrays_hashing;

import static common.PrintArray.printArray;

import java.util.HashMap;

public class TwoSum {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of elements in the input array `nums`.
     * This is because we iterate through the array only once, and each lookup and insertion operation in the HashMap takes O(1) time on average.
     *
     * Space Complexity: O(n)
     * The space complexity of this solution is O(n), where n is the number of elements in the input array `nums`.
     * This is because we store at most n elements in the HashMap.
     */
    private static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num; // Calculate the difference needed to meet the target

            // Check if the required difference exists in the map
            if (map.containsKey(diff)) {
                // If it exists, return the indices of the two numbers
                return new int[] {map.get(diff), i};
            }

            // Otherwise, add the current number and its index to the map
            map.put(num, i);
        }

        // Return an empty array if no solution is found
        return new int[0];
    }

    public static void main(String[] args) {
        int[] array1 = {2, 7, 11, 15};
        int[] array2 = {3, 2, 4};
        int[] array3 = {3, 3};

        printArray(twoSum(array1, 9));
        printArray(twoSum(array2, 6));
        printArray(twoSum(array3, 6));
        printArray(twoSum(array3, 7));
    }
}
