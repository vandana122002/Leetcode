class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length, k=0;
        int[] ans = new int[n];
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int size1 = arr1.size();
        int size2 = arr2.size();
        for(int i=2; i<n; i++)
        {
            size1 = arr1.size();
            size2 = arr2.size();
            if(arr1.get(size1-1)>arr2.get(size2-1))
            {
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
            
        }

        size1 = arr1.size();
        size2 = arr2.size();

        for(int i=0; i<size1; i++)
        {
            ans[i] = arr1.get(i);
        }

        for(int i=size1; i<n; i++)
        {
            ans[i] = arr2.get(k++);
        }

        return ans;
    }
}