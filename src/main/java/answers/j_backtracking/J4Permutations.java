package answers.j_backtracking;

import java.util.ArrayList;
import java.util.List;

public class J4Permutations {
    /**
     * Key Techniques:
     * ✅ Backtracking → Ensures a structured and systematic approach.
     * ✅ O(n!) Time Complexity → Generates all possible orderings.
     * ✅ Handles Unique & Duplicate Elements → Works across different input variations.
     * Time Complexity: O(n!)
     * The time complexity of this solution is O(n!), where n is the number of elements.
     * This is due to the nature of permutations, where we generate all possible orderings.
     *
     * Space Complexity: O(n)
     * The space complexity is O(n) for recursive function calls and temporary lists used in backtracking.
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        // Base case: if temporary list contains all elements, add to result
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Iterate through choices
        for (int num : nums) {
            if (tempList.contains(num)) continue; // Skip if already used

            tempList.add(num);
            backtrack(nums, tempList, result); // Recur
            tempList.remove(tempList.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("All Permutations:");
        System.out.println(permute(nums));
    }
}
