class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        // Case 1: Don't rob first house
        int case1 = robLinear(nums, 1, n - 1);

        // Case 2: Don't rob last house
        int case2 = robLinear(nums, 0, n - 2);

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {

        int prev = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {

            int take = nums[i] + prev2;

            int notTake = prev;

            int curi = Math.max(take, notTake);

            prev2 = prev;
            prev = curi;
        }

        return prev;
    }
}