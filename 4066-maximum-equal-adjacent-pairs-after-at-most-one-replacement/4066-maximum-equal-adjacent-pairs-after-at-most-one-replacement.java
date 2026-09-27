class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int base = 0, n=nums.length;
        HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<>();
        for(int i=1; i<n; i++)
        {
            int a = nums[i-1];
            int b = nums[i];

            if(a==b)base++;
            else{
                hm.putIfAbsent(a, new HashMap<>());
                HashMap<Integer, Integer> innerA = hm.get(a);
                int cnt = innerA.getOrDefault(b,0);
                innerA.put(b, cnt+1);

                hm.putIfAbsent(b, new HashMap<>());
                HashMap<Integer, Integer> innerB = hm.get(b);
                int cntB = innerB.getOrDefault(a,0);
                innerB.put(a, cntB+1);
            }
        }

        int ans = 0;
        for(HashMap<Integer, Integer> inner: hm.values())
        {
            for(int count: inner.values())
            {
                ans = Math.max(ans,count);
            }
        }
        return ans+base;
    }
}