class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n][2];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        return solve(0,1,prices,fee);
    }

    public int solve(int idx, int buy, int[] arr,int fee)
    {
        if(idx == arr.length)return 0;
        if(dp[idx][buy] != -1)return dp[idx][buy];
        int profit = 0;;
        if(buy == 1)
        {
            profit = Math.max(-arr[idx]+solve(idx+1,0,arr,fee), 
                              0+solve(idx+1,1,arr,fee));
        }
        else{
            profit = Math.max(arr[idx]-fee+solve(idx+1,1,arr,fee), 
                              0+solve(idx+1,0,arr,fee));
        }
        return dp[idx][buy]=profit;
    }
}