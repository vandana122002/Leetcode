class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int ans = countCoinCombWays(coins, amount, n);
        return ans;
    }

    public int countCoinCombWays(int[] arr, int amount, int n)
    {
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<=amount; i++)
        {
            if(i%arr[0] == 0)
            dp[0][i] = 1;
        }

        for(int idx=1; idx<n; idx++)
        {
            for(int target=0; target<=amount; target++)
            {
                int notTake = dp[idx-1][target];
                int take = 0;
                if(arr[idx] <= target) take=dp[idx][target-arr[idx]];

                dp[idx][target] = notTake+take;
            }
        }
        return dp[n-1][amount];
    }
}