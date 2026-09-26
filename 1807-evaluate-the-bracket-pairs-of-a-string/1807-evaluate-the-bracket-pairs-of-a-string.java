class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hm = new HashMap<>();
        int n = knowledge.size();
        for(int i=0; i<n; i++)
        {
            hm.put(knowledge.get(i).get(0),knowledge.get(i).get(1) );
        }
        StringBuilder res = new StringBuilder();
        int len = s.length();
        for(int i=0; i<len; i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                StringBuilder sb = new StringBuilder();
                i++;
                while(s.charAt(i) != ')')
                {
                    sb.append(s.charAt(i));
                    i++;
                }
        
                String key = sb.toString();
                if(hm.containsKey(key))
                {
                    res.append(hm.get(key));
                }else{
                    res.append("?");
                }
            }else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}