class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][4];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return solve(0,0,prices);
    }

    private int solve(int i, int transaction, int[] prices)
    {
        if(i == prices.length || transaction==4)
        {
            return 0;
        }

        if(dp[i][transaction] != -1)
        return dp[i][transaction];

        if(transaction %2 ==0)
        {
            dp[i][transaction] = Math.max(
                -prices[i] + solve(i + 1, transaction + 1, prices),
                solve(i + 1, transaction, prices)
            );
        }else{
            dp[i][transaction] = Math.max(
                prices[i] + solve(i + 1, transaction + 1, prices),
                solve(i + 1, transaction, prices)
            );
        }

        return dp[i][transaction];
    }
}