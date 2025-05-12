package answers.e_sliding_window;

import static common.PrintArray.printArray;

public class E1BestTimetoBuyandSellStock {
    /**
     * Key Techniques:
     * ✅ One-Pass Greedy Approach → Efficiently tracks min price and max profit.
     * ✅ O(n) Time Complexity → Processes prices in a single pass.
     * ✅ O(1) Space Complexity → Requires only two variables.
     *
     * Time Complexity: O(n)
     * We traverse the price list once, making the solution linear in time.
     *
     * Space Complexity: O(1)
     * Uses only a few extra variables for calculations.
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Step 1: Traverse the array while tracking min price and max profit
        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // Update minimum price
            maxProfit = Math.max(maxProfit, price - minPrice); // Calculate max profit
        }

        return maxProfit; // Maximum achievable profit
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        printArray(new int[] {maxProfit(prices1)}); // Output: 5 (Buy at 1, Sell at 6)
        printArray(new int[] {maxProfit(prices2)}); // Output: 0 (No profitable trade)
    }
}
