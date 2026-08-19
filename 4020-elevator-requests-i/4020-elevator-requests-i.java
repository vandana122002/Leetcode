class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int sum = 0, diff = 0;
        for(int i=1; i<requests.length; i++)
        {
            diff = Math.abs(requests[i]-requests[i-1]);
            sum += diff;
        }
        sum += requests[0];
        return sum;
    }
}