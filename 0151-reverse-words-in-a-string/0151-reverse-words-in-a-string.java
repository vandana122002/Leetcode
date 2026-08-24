class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i=n-1; i>=0; i--)
        {
            while(i>=0 && s.charAt(i) == ' ')
            {
                i--;
            }
            sb.setLength(0);

            while(i>=0 && s.charAt(i) != ' ')
            {
                sb = sb.append(s.charAt(i));
                i--;
            }
            
            sb = sb.reverse();
            if(sb.length() > 0)
            {
                if(ans.length() > 0)
                {
                    ans.append(' ');
                }
                ans.append(sb);
            }
            // ans = ans.append(sb).append(' ');
        }
        return ans.toString();
    }
}