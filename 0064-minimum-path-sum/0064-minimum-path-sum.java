class Solution {
    int[][] dp;

    public int solve(int i, int j,int[][] arr)
    {
        if(i==0 && j==0) return arr[0][0];
        if(i<0 || j<0)return 1000000000;
        if(dp[i][j] != -1)return dp[i][j];
        int up=0, left=0;
        up = arr[i][j]+solve(i-1,j,arr);
        left = arr[i][j]+solve(i,j-1,arr);

        return dp[i][j] = Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return solve(n-1,m-1,grid);
    }
}