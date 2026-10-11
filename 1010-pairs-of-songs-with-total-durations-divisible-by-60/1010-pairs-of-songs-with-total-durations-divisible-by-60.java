class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq = new int[60];
        int res = 0;

        for(int t:time)
        {
            int r = t%60;
            int complement = (60-r)%60;
            res += freq[complement];
            freq[r]++;
        }
        return res;
    }
}