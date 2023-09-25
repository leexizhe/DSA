package common;

public class PrintArray {
    public static void printArray(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }
}
