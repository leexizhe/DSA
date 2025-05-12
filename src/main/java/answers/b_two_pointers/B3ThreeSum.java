package answers.b_two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B3ThreeSum {
    /**
     * Key Techniques:
     * ✅ Sorting → Ensures efficient duplicate elimination.
     * ✅ Two-Pointer Approach → Finds triplets without unnecessary iterations.
     * ✅ O(n^2) Time Complexity → Optimized compared to brute-force O(n^3).
     *
     * Time Complexity: O(n^2)
     * The outer loop runs O(n), and the two-pointer approach runs O(n) inside it.
     *
     * Space Complexity: O(n)
     * Stores triplet results in a list.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort for two-pointer approach

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate elements

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++; // Skip duplicate left values
                    while (left < right && nums[right] == nums[right + 1]) right--; // Skip duplicate right values
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {-1, 0, 1, 2, -1, -4};
        int[] array2 = {-1, 0, 1, 2, -1, -4};
        int[] array3 = {-2, 0, 1, 1, 2};
        System.out.println(threeSum(array1)); // Output: [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(threeSum(array2)); // Output: [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(threeSum(array3)); // Output: [[-2, 0, 2], [-2, 1, 1]]
    }
}
