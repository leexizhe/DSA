package answers.j_backtracking;

import java.util.*;

public class J5Subsets2 {
    /**
     * Key Techniques:
     * ✅ Backtracking with Duplicate Skipping → Ensures unique subsets when input contains duplicates.
     * ✅ Sorting Input → Allows easy skip of repeated elements during iteration.
     * ✅ Dynamic Subset Expansion → Recursively builds each subset with include/exclude decision.
     *
     * Time Complexity: O(2^n)
     * The number of subsets for n elements is 2^n. For each subset, we may do up to O(n) work.
     *
     * Space Complexity: O(n)
     * Stack depth at most n due to recursion; subsets are stored in output list, not call stack.
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path)); // Record the current subset

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates at the same recursion depth

            path.add(nums[i]); // Choose
            backtrack(nums, i + 1, path, result); // Explore
            path.remove(path.size() - 1); // Un-choose (backtrack)
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);

        System.out.println("Unique Subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
