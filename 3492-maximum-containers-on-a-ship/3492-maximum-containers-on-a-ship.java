class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        if(n==1 && w<maxWeight)return 1;
        // int ans = (int)Math.floor(maxWeight/w);
        // if(ans*n < maxWeight && n*n<ans)
        // return n*n;
        // else if(maxWeight/w == n)
        //  return maxWeight/w ;
        // else 
        // return n*n;
        if(n*n*w <= maxWeight)
        return n*n;
        else if(n*n*w > maxWeight)
        {
            int ans = (int)Math.floor(maxWeight/w);
            if(ans <= n*n)
            return ans;
            else return n*n;
        }return 0;
    }
}