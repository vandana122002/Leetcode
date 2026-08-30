class Solution {
    long mod = (1000000007);
    public int sumDecoded(long[] nums) {
        int n = nums.length;
        long ans = 0;
        for(long no: nums)
            {
                ans = (ans+decode(no))%mod;
            }
        return (int)ans;
    }

    public long decode(long n)
    {
        int width = (int)(n%10);
        long d = n/10;
        String s = String.valueOf(d);
        long x = Long.parseLong(s.substring(0,width));
        long y = Long.parseLong(s.substring(width));
        return power(x,y);
    }

    public long power(long x, long y)
    {
        long res = 1;
        while(y>0)
            {
                if(y%2 == 1)
                {
                    res = (res*x)%mod;
                } 
                x = (x*x)%mod;
                 y/= 2;
            }
        return res;
    }
}