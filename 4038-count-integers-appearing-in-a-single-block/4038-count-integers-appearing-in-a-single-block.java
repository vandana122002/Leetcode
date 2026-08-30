class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, Integer> lastIdx = new HashMap<>();
        HashSet<Integer> notSpecial = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++)
            {
                int x = nums[i];
                if(lastIdx.containsKey(x))
                {
                    if( (i-lastIdx.get(x)) >1 )
                    {
                        notSpecial.add(x);
                    }
                }
                lastIdx.put(x,i);
            }
        return lastIdx.size()-notSpecial.size();
    }
}