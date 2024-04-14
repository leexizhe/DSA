package answers.arrays_hashing;

import static common.PrintArray.printArray;

import java.util.HashMap;

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        /**
         * Time Complexity: O(n)
         * The time complexity of this solution is O(n), where n is the number of elements in the input array nums.
         * This is because we iterate through the array only once, and each lookup and insertion operation in the HashMap takes O(1) time on average.
         *
         * Space Complexity: O(n)
         * The space complexity of this solution is O(n), where n is the number of elements in the input array nums.
         * This is because we store at most n elements in the HashMap.
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(num, i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] array1 = {2, 7, 11, 15};
        int[] array2 = {3, 2, 4};
        int[] array3 = {3, 3};

        printArray(twoSum(array1, 9));
        printArray(twoSum(array2, 6));
        printArray(twoSum(array3, 6));
    }
}
