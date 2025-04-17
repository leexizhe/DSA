package answers.e_sliding_window;

import static common.PrintArray.printArray;

public class E1BestTimetoBuyandSellStock {

    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of elements in the input array `prices`.
     * This is because we iterate through the array only once using a two-pointer approach.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1), since we only use a few variables without additional storage.
     */
    public static int maxProfit1(int[] prices) {
        // Step 1: Initialize two pointers
        int left = 0; // Tracks the lowest buy price
        int right = 1; // Iterates through prices
        int result = 0; // Stores the maximum profit

        // Step 2: Iterate through the array to find max profit
        while (right < prices.length) {
            if (prices[left] < prices[right]) { // If selling at 'right' is profitable
                int diff = prices[right] - prices[left]; // Calculate profit
                result = Math.max(result, diff); // Update maximum profit
            } else {
                left = right; // Update 'left' to find a new buying price
            }
            right++; // Move 'right' to the next day
        }

        return result; // Return the maximum profit obtained
    }

    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of elements in the input array `prices`.
     * This is because we iterate through the array once to track the minimum price and calculate potential profits.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1), since we only use a few variables for calculations without extra storage.
     */
    private static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Iterate through the prices array
        for (int price : prices) {
            // Track the minimum price seen so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate potential profit at current price
            int potentialProfit = price - minPrice;
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        printArray(new int[] {maxProfit1(prices1)}); // Output: 5 (Buy at 1, Sell at 6)
        printArray(new int[] {maxProfit1(prices1)}); // Output: 5 (Buy at 1, Sell at 6)
        printArray(new int[] {maxProfit2(prices1)}); // Output: 5 (Buy at 1, Sell at 6)
        printArray(new int[] {maxProfit2(prices2)}); // Output: 0 (No profitable trade)
    }
}
