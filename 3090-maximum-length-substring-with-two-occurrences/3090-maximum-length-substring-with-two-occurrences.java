class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int i=0, j=0,ans =0;

        while(i<n && j<n)
        {
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j),0)+1);

            while(hm.getOrDefault(s.charAt(j),0) > 2)
            {
                int val = hm.get(s.charAt(i))-1;
                hm.put(s.charAt(i),val);
                i++;
            }

            ans = Math.max(ans, (j-i+1));
            j++;
        }return ans;
    }
}