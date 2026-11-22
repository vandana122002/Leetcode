class Pair{
    String first;
    int second;
    Pair(String first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        int steps = 0;
        q.add(new Pair(beginWord,1));
        Set<String> hs = new HashSet<String>();
        int len = wordList.size();
        for(int i=0; i<len; i++)
        {
            hs.add(wordList.get(i));
        }
        hs.remove(beginWord);
        while(!q.isEmpty())
        {
            String word= q.peek().first;
            steps = q.peek().second;
            q.remove();
            if(word.equals(endWord) == true)return steps;
            for(int i=0; i<word.length(); i++)
            {
                for(char ch ='a'; ch<='z'; ch++)
                {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(hs.contains(replacedWord) == true)
                    {
                        hs.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}