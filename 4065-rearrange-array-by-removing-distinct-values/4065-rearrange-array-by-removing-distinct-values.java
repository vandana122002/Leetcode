class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num :nums)
        {
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        int[] ans = new int[nums.length];
        while(!hm.isEmpty())
        {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int no : hm.keySet())
            {
                arr.add(no);
            }
            
            Collections.sort(arr);

            for(int val : arr)
            {
                ans[i++] = val;
                if(hm.get(val)==1)
                {
                    hm.remove(val);
                }else{
                    hm.put(val,hm.getOrDefault(val,0)-1);
                }
            }
        }
        return ans;
    }
}