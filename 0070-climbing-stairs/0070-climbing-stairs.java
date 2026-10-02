class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solution(n,dp);
    }

    private int solution(int n, int[] dp)
    {
        if(n == 0)return 1;
        if(n==1)return 1;
        if(dp[n] != -1)return dp[n];
        int oneStep = solution(n-1,dp);
        int twoStep = solution(n-2,dp);
        dp[n] = oneStep+twoStep; 
        return dp[n];
    }
}