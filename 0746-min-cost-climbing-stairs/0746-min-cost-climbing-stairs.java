class Solution {
    int[] dp;
    private int solve(int[]arr,int i){
        int n = arr.length;
        if(i>=n)
        {
            return 0;
        }
        if(dp[i]!= -1)return dp[i];
        int oneStep = solve(arr,i+1);
        int twoStep = solve(arr,i+2);
        dp[i] = arr[i]+Math.min(oneStep,twoStep);
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,0), solve(cost,1));
    }
}