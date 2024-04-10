package answers.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * Time Complexity:
     * The time complexity of this solution is O(n), where n is the number of elements in the array.
     * This is because iterating through the array takes O(n) time, and adding an element to the HashSet and checking for containment takes O(1) on average.
     *
     * Space Complexity:
     * The space complexity is O(n), where n is the number of elements in the array.
     * This is because the HashSet can contain at most n elements if all elements are unique.
     **/
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
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
