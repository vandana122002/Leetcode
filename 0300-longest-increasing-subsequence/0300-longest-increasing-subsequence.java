class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return solve(0,-1,nums,dp);
    }

    private int solve(int idx, int prevIdx,int[] arr,int[][]dp)
    {
        if(idx == arr.length)return 0;
        if(dp[idx][prevIdx+1] != -1)return dp[idx][prevIdx+1];
        int len = 0+solve(idx+1,prevIdx,arr,dp);
        if(prevIdx == -1 || arr[idx] > arr[prevIdx])
        {
            len = Math.max(len,1+solve(idx+1,idx,arr,dp));
        }

        return dp[idx][prevIdx+1] = len;
    }
}