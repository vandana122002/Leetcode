class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        solve(1, n, k,new ArrayList<>() );
        return ans;
    }

    void solve(int start, int n, int k, ArrayList<Integer> curr)
    {
        if(k==0)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(start > n)
        {
            return;
        }

        curr.add(start);
        solve(start+1,n,k-1, curr);
        curr.remove(curr.size()-1);
        solve(start+1, n, k, curr);
    }
}