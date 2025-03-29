package answers.b_two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B3ThreeSum {
    /**
     * Time Complexity: O(n^2)
     * - Sorting the array takes O(n log n).
     * - The nested loop for finding triplets using two pointers takes O(n^2).
     * - Therefore, the overall time complexity is O(n^2).
     *
     * Space Complexity: O(n)
     * - The space complexity is O(n) due to the storage of the result list and the sorting operation.
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        // Step 1: Sort the array to simplify finding triplets
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // Step 2: Iterate through the array to find triplets
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicates for the current element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Initialize two pointers
            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Find pairs that sum to the target (-nums[i])
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    // If the sum is greater than 0, move the right pointer backward
                    right--;
                } else if (sum < 0) {
                    // If the sum is less than 0, move the left pointer forward
                    left++;
                } else {
                    // Add the triplet to the result list
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move the left pointer forward while avoiding duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Move the right pointer backward while avoiding duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both pointers to continue finding triplets
                    left++;
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
