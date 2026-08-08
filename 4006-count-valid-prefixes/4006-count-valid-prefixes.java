class Solution {
    public int countValidPrefixes(String s) {
        int res = 0, diff = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            diff += s.charAt(i) == '1' ? 1 : -1;
            if (Math.abs(diff) <= 1) res++;
        }
        return res;
    }
}