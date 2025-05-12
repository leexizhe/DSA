package answers.a_arrays_hashing;

import java.util.HashSet;

public class A1ContainsDuplicate {
    /**
     * Key Techniques:
     * ✅ HashSet → Efficiently tracks unique values.
     * ✅ O(n) Time Complexity → Single-pass lookup.
     * ✅ O(n) Space Complexity → Stores all distinct elements.
     *
     * Time Complexity: O(n)
     * Each element is processed once, ensuring linear efficiency.
     *
     * Space Complexity: O(n)
     * Stores distinct elements in the hash set.
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) return true; // Duplicate detected
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate(nums2));
        System.out.println(containsDuplicate(nums3));
    }
}
