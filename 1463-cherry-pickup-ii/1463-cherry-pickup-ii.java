class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][m];
        for(int[][] arr: dp )
        {
            for(int[] row:arr)
            {
                Arrays.fill(row,-1);
            }
        }
         return solve(0,0,m-1,grid);
    }

    private int solve(int i, int j1, int j2,int[][] mat)
    {
        int m = mat[0].length;
        if(j1<0 || j1>=m || j2<0 || j2>=m)return -100000000;
        if( i == mat.length-1)
        {
            if(j1 == j2)return mat[i][j1];
            else return mat[i][j1]+mat[i][j2];
        }

        if(dp[i][j1][j2] != -1)return dp[i][j1][j2];
        int max = 0;
        for(int dj1=-1; dj1<=1; dj1++)
        {
            for(int dj2=-1; dj2<=1; dj2++)
            {
                if(j1 == j2)
                max = Math.max(max,mat[i][j1]+solve(i+1,j1+dj1, j2+dj2, mat));
                else
                max = Math.max(max,mat[i][j1]+mat[i][j2]+solve(i+1,j1+dj1, j2+dj2, mat));
            }
        }
        dp[i][j1][j2] = max;
        return max;
    }
}