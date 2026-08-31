class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int ans = 0, cnt = 0;
        for(int i=0; i<nums.length; i++)
        {
            ans += nums[i];
            if(ans == 0)cnt++;
        }
        return cnt;
    }
}