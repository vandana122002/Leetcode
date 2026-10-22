class Solution {
    int[][] dp;
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        dp = new int[n][m];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return solve(n-1,m-1,s,p);
    }

    public boolean solve(int i, int j,String s1,String s2)
    {
        if(i<0 && j<0)return true;
        if(j<0 && i>=0)return false;
        if(i<0 && j>=0)
        {
            for(int x=0; x<=j; x++)
            {
                if(s2.charAt(x) != '*')
                return false;
            }
            return true;
        }

        if(dp[i][j] != -1)return dp[i][j] == 1;
        boolean ans;
        if(s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?')
            ans =  solve(i-1,j-1,s1,s2);

        else if(s2.charAt(j) == '*')
        {
            ans = solve(i-1,j,s1,s2)||solve(i,j-1,s1,s2) ;
        }

        else{
            ans = false;
        }
        dp[i][j] = ans?1:0;
        return ans;
    }
}