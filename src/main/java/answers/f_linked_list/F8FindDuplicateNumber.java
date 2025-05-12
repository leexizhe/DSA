package answers.f_linked_list;

public class F8FindDuplicateNumber {
    /**
     * Key Techniques:
     * ✅ Floyd’s Cycle Detection → Efficient in detecting duplicates in cyclic structures.
     * ✅ O(n) Time Complexity → Processes elements in linear time.
     * ✅ O(1) Space Complexity → No extra memory usage beyond pointers.
     *
     * Time Complexity: O(n)
     * We traverse the array to detect cycles, making the solution linear in time.
     *
     * Space Complexity: O(1)
     * Uses only two pointer variables, requiring constant space.
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        // Step 1: Detect cycle in linked-index structure
        do {
            slow = nums[slow]; // Move one step
            fast = nums[nums[fast]]; // Move two steps
        } while (slow != fast);

        // Step 2: Find cycle start (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // Duplicate number
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate Number: " + findDuplicate(nums)); // Output: 2
    }
}
