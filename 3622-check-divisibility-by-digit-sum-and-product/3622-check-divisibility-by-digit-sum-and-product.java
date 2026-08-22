class Solution {
    public boolean checkDivisibility(int n) {
        int sum =0, prod=1;
        int num = n;
        while(n > 0)
        {
            int dig = n%10;
            sum += dig;
            prod *= dig;
            n /= 10;
        }
        int total = sum+prod;
        // System.out.print(total);
        // System.out.print(n);

        // System.out.print(n%total);
        return (num%total==0)?true:false;
    }
}