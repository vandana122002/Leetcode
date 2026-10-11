class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[] freq = new int[24];
        long res = 0;
        for(int h:hours)
        {
            int r = h%24;
            int complement = (24 - r) % 24;

            res += freq[complement];
            // res += freq[r];
            freq[r]++;
        }
        return res;
    }
}