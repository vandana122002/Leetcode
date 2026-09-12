class Solution {
    public int countSpecialIntegers(int[] nums) {
        int cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n:nums)
        {
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        int n = hm.size();
        for(Map.Entry<Integer, Integer> mp: hm.entrySet())
        {
            int freq = mp.getValue();
            if(freq == 3)
            {
                int res = equSpace(mp.getKey(), nums);
                if(res==1)cnt++;

            }
        }return cnt;
    }
     
    public int equSpace(int num, int[] arr)
    {
        int idx1=0, idx2=0, idx3=0, cnt=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == num && cnt==0)
            {
                idx1 = i;
                cnt++;
            }else if(arr[i] == num && cnt==1)
            {
                idx2 = i;
                cnt++;
            }
            else if(arr[i] == num && cnt == 2)
            {
                idx3 = i;
            }
            // System.out.print(idx1+" "+idx2+" "+idx3);
        }
            if(idx2-idx1==idx3-idx2)return 1;
        return 0;
    }
}