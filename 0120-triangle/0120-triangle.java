class Solution {
    int[][] dp;
    boolean[][] visited;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        visited = new boolean[n][n];
        
        return solve(0,0,triangle);
     }

     private int solve(int i, int j, List<List<Integer>> triangle)
     {
        if(i == triangle.size()-1)
        {
            return triangle.get(i).get(j);
        }

        if (visited[i][j]) {
            return dp[i][j];
        }
        int down = triangle.get(i).get(j)+ solve(i + 1, j, triangle);
        int diag = triangle.get(i).get(j)+ solve(i + 1, j + 1, triangle);

        visited[i][j] = true;
        return dp[i][j] = Math.min(down, diag);

     }
}