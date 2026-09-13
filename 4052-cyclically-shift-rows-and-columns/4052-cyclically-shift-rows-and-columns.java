class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int k = rowShift[i] % n;

            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][(j + k) % n];
            }
        }

        int[][] ans = new int[n][n];

        for (int j = 0; j < n; j++) {
            int k = colShift[j] % n;

            for (int i = 0; i < n; i++) {
                ans[i][j] = temp[(i + k) % n][j];
            }
        }

        return ans;
    }
}