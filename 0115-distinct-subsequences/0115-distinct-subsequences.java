class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int i = s.length();
        int j = t.length();
        dp = new int[i][j];
        for(int[] row: dp)
        {
            Arrays.fill(row,-1);
        }

        return solve(i-1, j-1, s, t);
    }

    public int solve(int i, int j, String s1, String s2)
    {
        if(j<0)return 1;
        if(i<0)return 0;
        if(dp[i][j] != -1)return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j] = (solve(i-1,j-1,s1,s2) + solve(i-1,j,s1,s2));
        }

        return dp[i][j] = solve(i-1,j,s1,s2);
    }
}