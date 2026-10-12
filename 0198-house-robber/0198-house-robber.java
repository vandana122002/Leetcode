class Solution {
    int[] dp;
    public int solve(int idx, int[] arr)
    {
        if(idx == 0)
        {
            return arr[0];
        }
        if(idx < 0)
        {
            return 0;
        }
        if(dp[idx] != -1)return dp[idx];
        int pick = arr[idx]+solve(idx-2,arr);
        int notPick = 0+solve(idx-1,arr);
        return dp[idx] = Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1, nums);
    }
}