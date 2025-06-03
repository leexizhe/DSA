package answers.j_backtracking;

import java.util.ArrayList;
import java.util.List;

public class J2CombinationSum {
    /**
     * Key Techniques:
     * ✅ Backtracking → Systematically explores all valid combinations.
     * ✅ Uses recursion with dynamic choice selection.
     * ✅ Allows repeated use of elements while preventing unnecessary recomputation.
     *
     * Time Complexity: O(2^n)
     * - Each element has multiple choices leading to exponential search space.
     *
     * Space Complexity: O(target / min_element)
     * - Maximum recursion depth depends on `target` and the smallest candidate value.
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Store valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue; // Prune unnecessary recursion

            current.add(candidates[i]);  // Include current number
            backtrack(i, candidates, target - candidates[i], current, result); // Allow reuse
            current.remove(current.size() - 1); // Backtrack and try next option
        }
    }

    /**
     * Key Techniques:
     * ✅ Depth-First Search (DFS) → Explores all possible combinations recursively.
     * ✅ Explicit Inclusion Choices → Allows repeated use of elements while maintaining order.
     * ✅ Efficient Recursive Approach → Backtracks to explore different valid paths.
     *
     * Time Complexity: O(2^n)
     * - Each element can be included multiple times, leading to an exponential search space.
     *
     * Space Complexity: O(target / min_element)
     * - Maximum recursion depth depends on `target` and the smallest candidate value.
     */
    public static List<List<Integer>> combinationSumDFS(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Store valid combination
            return;
        }

        if (index >= candidates.length || target < 0) return; // Stop if out of bounds or invalid target

        current.add(candidates[index]);  // Include current number
        dfs(index, candidates, target - candidates[index], current, result); // Stay at the same index (allow reuse)

        current.remove(current.size() - 1); // Backtrack
        dfs(index + 1, candidates, target, current, result); // Move to the next index
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);
        System.out.println("Valid Combinations:");
        System.out.println(combinations);
        List<List<Integer>> combinationSumDFS = combinationSumDFS(candidates, target);
        System.out.println("Valid Combinations DFS:");
        System.out.println(combinationSumDFS);
    }
}
