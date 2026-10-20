class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum =0, n=stones.length;
        for(int i=0; i<n; i++)
        {
            sum += stones[i];
        }
        boolean[][] dp = new boolean[n][sum+1];
        // for(boolean[] row: dp)
        // {
        //     Arrays.fill(dp,0);
        // }

        for(int i=0; i<n; i++)dp[i][0] = true;
        if(stones[0] <= sum)dp[0][stones[0]] = true;

        for(int idx=1; idx<n; idx++)
        {
            for(int target=1; target<=sum; target++)
            {
                boolean notTake = dp[idx-1][target];
                boolean take = false;

                if(stones[idx] <= target)
                {
                    take = dp[idx-1][target-stones[idx]];
                }

                dp[idx][target]  = notTake||take;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int s1 = 0; s1<=sum/2; s1++)
        {
            if(dp[n-1][s1])
            min = Math.min(min, Math.abs((sum-s1)-s1));
        }

        return min;
    }
}