class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        if(nums.length == 1)
        return nums[0]+1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int j = 0, cnt = 1;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        hm.put(1, 0);
        for(int i=0; i<n-1; i++)
        {
            j=i+1;
            prefixSum[j] = prefixSum[i]+nums[j];
            if(nums[j]-nums[i] == 1)
            {
                cnt++;
                hm.put(cnt,j);
                
            }
        
            else 
            {
                break;
            }
            // cnt = 1;
        }

        int max = 0;
        for(Map.Entry<Integer, Integer> entry: hm.entrySet())
        {
            int no = entry.getKey();
            max = Math.max(max,no);
        }  
        int freq = hm.get(max);  
        int ans = prefixSum[freq];
        HashSet<Integer> hs = new HashSet<>();
        for(int x:nums)
        {
            hs.add(x);
        }
        while(hs.contains(ans))
        {
            ans++;
        }
        return ans;
    }
}