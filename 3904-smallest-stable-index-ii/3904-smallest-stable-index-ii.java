class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        // int Min = Integer.MAX_VALUE;
        // int Max = Integer.MIN_VALUE;
        max[0] = nums[0];
        min[n-1] = nums[n-1];
        for(int i=1; i<n; i++)
        {
            min[n-i-1] = Math.min(min[n-i],nums[n-i-1]);
            max[i] = Math.max(max[i-1], nums[i]);
        }
        // int ans = -1;
        int minans = 0;
        for( int j=0; j<n; j++)
        {
            minans = max[j]-min[j];
            if(minans<=k )
            {
               return j;
            }
        }
        return -1;
    }
}