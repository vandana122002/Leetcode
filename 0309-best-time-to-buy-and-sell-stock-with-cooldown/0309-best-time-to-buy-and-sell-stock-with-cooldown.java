class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        return solve(0,1,prices);
    }

    public int solve(int idx, int buy, int[] arr)
    {
        if(idx >= arr.length)return 0;
        if(dp[idx][buy] != -1)return dp[idx][buy];
        int profit = 0;;
        if(buy == 1)
        {
            profit = Math.max(-arr[idx]+solve(idx+1,0,arr), 
                              0+solve(idx+1,1,arr));
        }
        else{
            profit = Math.max(arr[idx]+solve(idx+2,1,arr), 
                              0+solve(idx+1,0,arr));
        }
        return dp[idx][buy]=profit;
    }
}