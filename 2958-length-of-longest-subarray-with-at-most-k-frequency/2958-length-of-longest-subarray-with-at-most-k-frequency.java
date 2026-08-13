class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int n = nums.length;
        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < n && j < n) {

            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while (mp.get(nums[j]) > k) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                i++;
            }

            ans = Math.max(ans, j - i + 1);

            j++;
        }

        return ans;
    }
}