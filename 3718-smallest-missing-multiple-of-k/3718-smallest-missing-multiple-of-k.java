class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n: nums)
        {
            hm.put(n, hm.getOrDefault(n,0)+1);
        }

        for(int i=1; i<100; i++)
            {
                if(!hm.containsKey(k*i))
                return k*i;
            }
        return 101;
    }
}