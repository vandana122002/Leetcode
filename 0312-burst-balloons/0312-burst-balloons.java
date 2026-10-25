class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = 1;
        a[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            a[i + 1] = nums[i];
        }
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        return solve(1, n, a, dp );
    }

    private int solve(int i, int j, int[] a, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxCoins = 0;
        for (int idx = i; idx <= j; idx++) {
            int cost = a[i - 1] * a[idx] * a[j + 1]
                     + solve(i, idx - 1, a, dp)
                     + solve(idx + 1, j, a, dp);

            maxCoins = Math.max(maxCoins, cost);
        }

        return dp[i][j] = maxCoins;
    }
}