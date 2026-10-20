class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0, n= nums.length;
        for(int no: nums)
        {
            sum += no;
        }
        if(sum%2==1)return false;
        dp = new int[n][(sum/2)+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return solve(n-1,sum/2,nums);
    }

    private boolean solve(int idx, int sum,int[] nums)
    {
        if(sum == 0)return true;
        if(idx == 0)return (nums[0] == sum);
        if(dp[idx][sum] != -1)return dp[idx][sum]==1;
        boolean notTake = solve(idx-1,sum,nums);
        boolean take = false;
        if(sum >= nums[idx])
        {
            take = solve(idx-1,sum-nums[idx],nums);
        }

        dp[idx][sum] = (notTake || take)?1:0;
        return dp[idx][sum]==1;
    }
}