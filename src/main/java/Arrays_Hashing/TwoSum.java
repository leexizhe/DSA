package Arrays_Hashing;

import java.util.HashMap;

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        // time O(n)
        // space O(n)

        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (hashMap.containsKey(diff)) {
                return new int[] {hashMap.get(diff), i};
            } else {
                hashMap.put(num, i);
            }
        }
        return null;
    }

    private static void printArray(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] array1 = {2,7,11,15};
        int[] array2 = {3,2,4};
        int[] array3 = {3,3};

        printArray(twoSum(array1, 9));
        printArray(twoSum(array2, 6));
        printArray(twoSum(array3, 6));
    }
}
