package answers.j_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J2CombinationSum2 {
    /**
     * Key Techniques:
     * ✅ Sorting + Pruning → Helps efficiently skip duplicate elements.
     * ✅ Backtracking Approach → Allows exploration of all valid combinations.
     * ✅ O(2^N) Complexity → Generates all unique subsets while skipping duplicates.
     *
     * Time Complexity: O(2^N)
     * We explore all possible subsets but optimize by skipping duplicate numbers.
     *
     * Space Complexity: O(N) (Recursive Stack + Combination Storage)
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sorting helps in skipping duplicates easily
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start, int target, int[] candidates, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // Pruning: Stop if number exceeds remaining target

            cur.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates, cur, res); // Move to the next index
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println("Unique Combinations: " + result);
    }
}