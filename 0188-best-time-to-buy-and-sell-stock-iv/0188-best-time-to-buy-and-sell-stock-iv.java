class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];
        
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        return solve(0,0,prices,dp,k);
    }

    private int solve(int i, int transaction, int[] prices, int[][] dp, int k)
    {
        if(i==prices.length || transaction == 2*k)
        {
            return 0;
        }

        if(dp[i][transaction] != -1)
        return dp[i][transaction];

        if(transaction % 2 == 0)
        {
             dp[i][transaction] = Math.max(
                -prices[i] + solve(i + 1, transaction + 1, prices, dp, k),
                solve(i + 1, transaction, prices, dp, k)
            );
        } else {
            dp[i][transaction] = Math.max(
                prices[i] + solve(i + 1, transaction + 1, prices, dp, k),
                solve(i + 1, transaction, prices, dp, k)
            );
        }

        return dp[i][transaction];
    }
}