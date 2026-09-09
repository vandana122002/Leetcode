class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long[] prefix = new long[6];
        long initialCount = 999000;

        for (int i = 1; i < 6; i++) {
            prefix[i] = prefix[i - 1] + initialCount * i;

            if (i == 5) {
                prefix[i] = prefix[i - 1] + 5;
                break;
            }

            initialCount = initialCount * 1000;
        }

        if (n < 1000) {
            return 0;
        } 
        else if (n >= 1000 && n <= 999999L) {
            ans = prefix[0] + (n - 1000 + 1) * 1;
        } 
        else if (n >= 1000000L && n <= 999999999L) {
            ans = prefix[1] + (n - 1000000L + 1) * 2;
        } 
        else if (n >= 1000000000L && n <= 999999999999L) {
            ans = prefix[2] + (n - 1000000000L + 1) * 3;
        } 
        else if (n >= 1000000000000L && n <= 999999999999999L) {
            ans = prefix[3] + (n - 1000000000000L + 1) * 4;
        } 
        else {
            ans = prefix[4] + 5;
        }

        return ans;
    }
}