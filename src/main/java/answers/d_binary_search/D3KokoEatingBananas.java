package answers.d_binary_search;

public class D3KokoEatingBananas {
    /**
     * Key Techniques:
     * ✅ Binary Search on Eating Speed → Efficiently finds the minimum speed Koko needs.
     * ✅ O(log(maxPile) * n) Time Complexity → Optimally searches within speed constraints.
     * ✅ O(1) Space Complexity → Performs in-place calculations.
     *
     * Time Complexity: O(n log maxPile)
     * We apply binary search on the possible speeds, each check taking O(n).
     *
     * Space Complexity: O(1)
     * Uses only a few extra variables for search tracking.
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Integer division always rounds down

            long time = 0;
            for (int pile : piles) {
                time += (pile + mid - 1) / mid; // Integer division trick to avoid floating-point imprecision
            }

            // If Koko can finish within h hours, reduce speed to find minimum possible rate
            if (time <= h) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] piles1 = {3, 6, 7, 11};
        int[] piles2 = {30, 11, 23, 4, 20};
        int[] piles3 = {100, 200, 300};

        System.out.println(minEatingSpeed(piles1, 8)); // Output: 4
        System.out.println(minEatingSpeed(piles2, 5)); // Output: 30
        System.out.println(minEatingSpeed(piles3, 10)); // Output: 60
    }
}
