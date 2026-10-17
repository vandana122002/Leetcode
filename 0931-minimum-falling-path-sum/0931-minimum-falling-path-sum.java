class Solution {
    int[][] dp;
    boolean[][] visited;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        visited = new boolean[n][m];
        
        int min = Integer.MAX_VALUE;
        for(int j=0; j<m; j++)
        {
            min = Math.min(min, solve(n-1,j,matrix));
        }
        return min;
    }

    private int solve(int i, int j, int[][] mat)
    {
        if(j<0 || j>=mat[0].length)
        return 1000000000;
        if(i == 0)return mat[0][j];
        if (visited[i][j]) {
            return dp[i][j];
        }
        visited[i][j] = true;
        
        int s = mat[i][j]+solve(i-1,j,mat);
        int ld = mat[i][j]+solve(i-1,j-1,mat);
        int rd = mat[i][j]+solve(i-1,j+1,mat);

        return dp[i][j] = Math.min(s,Math.min(ld,rd));
    }
}