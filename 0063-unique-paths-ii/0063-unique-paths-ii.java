class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        final int MOD = 1_000_000_007;

    long[] prev = new long[m];

    for (int i = 0; i < n; i++) {
        long[] cur = new long[m];

        for (int j = 0; j < m; j++) {

            if (obstacleGrid[i][j] == 1) {
                cur[j] = 0;
            }

            else if (i == 0 && j == 0) {
                cur[j] = 1;
            }

            else {
                long up = 0;
                long left = 0;

                if (i > 0) {
                    up = prev[j];
                }

                if (j > 0) {
                    left = cur[j - 1];
                }

                cur[j] = up + left;
            }
        }

        prev = cur;
    }
        return (int)prev[m - 1];
    }
}