package answers.a_arrays_hashing;

import java.util.HashSet;

public class A1ContainsDuplicate {
    /**
     * Time Complexity: O(n)
     * The loop iterates through all n elements in the array.
     * For each element, we perform HashSet.contains() and HashSet.add(), which take O(1) on average.
     *
     * Space Complexity: O(n)
     * In the worst-case scenario (when there are no duplicates),
     * we may store all n elements of the array in the HashSet.
     * The space used by the HashSet is proportional to the number of elements stored, resulting in a space complexity of O(n).
     */
    public static boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store elements
        HashSet<Integer> set = new HashSet<>();

        // Loop through the array
        for (int num : nums) {
            // If the element already exists in the set, we found a duplicate
            if (set.contains(num)) {
                return true;
            }
            // Otherwise, add the element to the set
            set.add(num);
        }

        // No duplicates found
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
