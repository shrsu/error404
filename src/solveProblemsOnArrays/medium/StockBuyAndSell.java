package solveProblemsOnArrays.medium;

public class StockBuyAndSell {

    /**
     * Returns the maximum profit that can be achieved
     * by buying and selling the stock once.
     *
     * @param prices array of stock prices by day
     * @return maximum possible profit, or 0 if none
     */
    public int maxProfit(int[] prices) {

        // Edge case: no transaction possible
        if (prices.length <= 1) {
            return 0;
        }

        // Minimum price seen so far
        int minPrice = prices[0];

        // Maximum profit achievable
        int maxProfit = 0;

        // Iterate through prices starting from day 1
        for (int i = 1; i < prices.length; i++) {

            // Update minimum price if a lower price is found
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate profit if selling on current day
            else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}

