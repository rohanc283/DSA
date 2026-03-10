class Solution {
    Integer[][] dp;

    private int solve(int[] prices, int i, int free) {
        if (i >= prices.length)
            return 0;

        if (dp[i][free] != null)
            return dp[i][free];

        int buy = prices[i] + solve(prices, i + 1, i + 1);

        int dontBuy = Integer.MAX_VALUE;
        if (free > 0) {
            dontBuy = solve(prices, i + 1, free - 1);
        }

        return dp[i][free] = Math.min(buy, dontBuy);
    }

    public int minimumCoins(int[] prices) {
        dp = new Integer[prices.length][prices.length + 1];
        return solve(prices, 0, 0);
    }
}