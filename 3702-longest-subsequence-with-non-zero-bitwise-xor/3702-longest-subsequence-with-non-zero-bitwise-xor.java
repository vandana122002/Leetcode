class Solution {
    public int longestSubsequence(int[] nums) {
     int xor_all = 0;
     int n = nums.length;
     int flag = 0;
     for(int i =0;i<n;i++){
        xor_all^=nums[i];
        if(nums[i]>0)flag=1;
     }
     if(xor_all!=0)return n;
     if(flag!=0)return n-1;
     return 0;   
    }
}