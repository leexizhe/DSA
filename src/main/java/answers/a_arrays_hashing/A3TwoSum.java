package answers.a_arrays_hashing;

import static common.PrintArray.printArray;

import java.util.HashMap;

public class A3TwoSum {
    /**
     * Key Techniques:
     * ✅ HashMap → Enables constant-time lookup for complements.
     * ✅ O(n) Time Complexity → Single-pass solution.
     * ✅ O(n) Space Complexity → Stores key-value pairs efficiently.
     *
     * Time Complexity: O(n)
     * Each element is processed once, ensuring linear efficiency.
     *
     * Space Complexity: O(n)
     * Stores distinct elements in a hash map.
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i}; // Found pair
            }

            map.put(nums[i], i); // Store index of current number
        }

        return new int[] {-1, -1}; // No valid pair found
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
