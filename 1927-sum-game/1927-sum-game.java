class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int lfKnownSum = 0;
        int rtKnownSum = 0;

        int lfQMarkCnt = 0;
        int rtQMarkCnt = 0;
        
        for(int i=0; i<n; i++)
        {
            if(num.charAt(i) == '?')
            {
                if(i < n/2)
                {
                    lfQMarkCnt++;
                }else{
                    rtQMarkCnt++;
                }
            }else{
                if(i < n/2)
                {
                    lfKnownSum += num.charAt(i)-'0';
                }else{
                    rtKnownSum += num.charAt(i)-'0';
                }
            }
        }
        if((lfQMarkCnt+rtQMarkCnt) % 2 == 1)return true;
        return !( (2*lfKnownSum + 9*lfQMarkCnt) == (2*rtKnownSum + 9*rtQMarkCnt) );
    }
}