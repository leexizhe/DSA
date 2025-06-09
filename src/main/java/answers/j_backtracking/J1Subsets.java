package answers.j_backtracking;

import java.util.ArrayList;
import java.util.List;

public class J1Subsets {
    /**
     * Key Techniques:
     * ✅ Backtracking → Ensures all subsets are generated efficiently.
     * ✅ Uses recursion for structured exploration of choices.
     * ✅ Scales well for different input sizes.
     * Time Complexity: O(2^n)
     * Each element has two choices: included or not included, leading to 2^n subsets.
     *
     * Space Complexity: O(n)
     * Recursion depth is at most n, plus temporary storage for subset generation.
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add current subset

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // Include current element
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1); // Backtrack: remove last element
        }
    }

    /**
     * Key Techniques:
     * ✅ Depth-First Search (DFS) → Uses recursion to systematically explore all subset possibilities.
     * ✅ Explicit Inclusion/Exclusion Choices → Ensures structured branching for subset generation.
     * ✅ Efficient Recursive Approach → Backtracks to avoid unnecessary recomputation.
     *
     * Time Complexity: O(2^n)
     * - Each element has two choices: include or exclude, leading to 2^n subsets.
     *
     * Space Complexity: O(n)
     * - Recursion depth is at most n, plus temporary storage for subset generation.
     */
    public static List<List<Integer>> subsetsDFS(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private static void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset)); // Store subset once all elements are processed
            return;
        }

        subset.add(nums[i]); // Include current element
        dfs(nums, i + 1, subset, res);

        subset.remove(subset.size() - 1); // Exclude current element (Backtrack)
        dfs(nums, i + 1, subset, res);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        List<List<Integer>> subsetsDFS = subsetsDFS(nums);
        System.out.println("Generated Subsets:");
        System.out.println(subsets);
        System.out.println("Generated Subsets DFS:");
        System.out.println(subsetsDFS);
    }
}
