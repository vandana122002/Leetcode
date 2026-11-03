class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // int mid = n/2;
        int num = nums[n-1];
        int cnt = 0;
        for(int i=0; i<n; i++)
        {
            cnt = cnt+Math.abs(nums[i]-num);
        }
        return cnt;
    }
}

