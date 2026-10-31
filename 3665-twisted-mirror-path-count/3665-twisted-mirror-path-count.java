class Solution {
    int MOD = 1000000007;
    int m, n;
    int[][][] dp;

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n][2];

        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }

        long ans = solve(0, 1, 0, grid)
                 + solve(1, 0, 1, grid);

        return (int)(ans % MOD);
    }

    public int solve(int i, int j, int dir, int[][] grid)
    {
        if(i>=m || j>= n){
            return 0;
        }

        if(i==m-1 && j==n-1)
        {
            return 1;
        }

        if(dp[i][j][dir] != -1)
        {
            return dp[i][j][dir];
        }

        long ans = 0;
        if(grid[i][j] == 1)
        {
            if(dir == 0)
            {
                ans = solve(i+1,j,1,grid);
            }
            else{
                ans = solve(i, j+1,0,grid);
            }
        }else{
            ans += solve(i,j+1,0,grid);
            ans += solve(i+1,j,1,grid);
        }
        return dp[i][j][dir] = (int)(ans%MOD);
    }
}