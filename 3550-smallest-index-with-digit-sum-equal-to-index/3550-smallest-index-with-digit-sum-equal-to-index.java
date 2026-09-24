class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            if(nums[i]>9)
            {
                int sum = digSum(nums[i]);
                if(sum == i)
                return i;
            }else if(nums[i] == i)
            {
                return i;
            }
        }return -1;
    }

    public int digSum(int num)
    {
        int no = num;
        int sum = 0;
        while(num > 0)
        {
            int dig = num%10;
            sum += dig;
            num /= 10;
        }
        return sum;
    }
}