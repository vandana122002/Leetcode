class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        // for(int i=0; i<n; i++)
        // {
        //     hm.put(nums[i],i);
        // }

        for(int j=0; j<n; j++)
        {
            // if(hm.isEmpty())
            // {
            //     hm.put(nums[j],j );
            // }
            {
                int num1 = nums[j];
                int num2 = target - num1;
                if(hm.containsKey(num2))
                {
                    ans[0] = j;
                    ans[1] = hm.get(num2);
                    return ans;
                }
                hm.put(nums[j],j);
            }
            
        }return ans;
    }
}