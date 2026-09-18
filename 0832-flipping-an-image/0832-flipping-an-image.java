class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;
        int[][] res = new int[n][m];
        
        for(int i=0; i<n; i++)
        {
            for(int j=m-1; j>=0; j--)
            {
                int num = image[i][j];
                int invert = (num==0)?1:0;
                res[i][m - 1 - j] = invert;
            }

        }

        return res;
    }
}