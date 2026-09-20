class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        int len = s.length();
        for(int i=0; i<len; i++)
        {
            ans += (26-(s.charAt(i)-'a'))*(i+1);
        }
        return ans;
    }
}