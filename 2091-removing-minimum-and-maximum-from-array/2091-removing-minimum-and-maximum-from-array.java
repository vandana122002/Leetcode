class Solution {
    public int minimumDeletions(int[] nums) {
        // int smallest = Integer.MAX_VALUE;
        // int largest = Integer.MIN_VALUE;
        // int largestIdx = 0;
        // int smallestIdx = 0;
        // int len = nums.length;
        // int cnt = 1;
        // for(int i=0; i<len; i++)
        // {
        //     if(nums[i]>largest)
        //     {
        //         largest = nums[i];
        //         largestIdx = i;
        //     }

        //     if(nums[i] < smallest)
        //     {
        //         smallest = nums[i];
        //         smallestIdx = i;
        //     }
        // }
        // System.out.print(largest+" "+ largestIdx);
        // System.out.print(smallest+" "+ smallestIdx);
        // if((smallestIdx < len/2) && (largestIdx < len/2))
        // {
        //     cnt = Math.max(largestIdx,smallestIdx)+1;
        // }
        // else if((smallestIdx<len/2 && largestIdx > len/2) || (smallestIdx>len/2 && largestIdx < len/2))
        // {
        //     int idx = Math.min(smallestIdx,largestIdx);
        //     cnt = idx+1;
        //     idx = Math.max(smallestIdx, largestIdx);
        //     cnt += len-idx;
        // }
        // else if(smallestIdx>len/2 && largestIdx>len/2)
        // {
        //     cnt = len-Math.min(smallestIdx,largestIdx);
        // }
        // else if(smallestIdx==len/2 )
        // {
        //     if(largestIdx < len/2)
        //     {
        //         cnt = smallestIdx+1;
        //     }
        //     else if(largestIdx > len/2)
        //     {
        //         cnt = len-smallestIdx;
        //     }
        // }
        // else if(largestIdx==len/2 )
        // {
        //     if(smallestIdx < len/2)
        //     {
        //         cnt = largestIdx+1;
        //     }
        //     else if(smallestIdx > len/2)
        //     {
        //         cnt = len-largestIdx;
        //     }
        // }
        // return cnt ;
        int n = nums.length;

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {

            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }

            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        int front = Math.max(minIdx, maxIdx) + 1;
        int back = n - Math.min(minIdx, maxIdx);
        int both = Math.min(minIdx, maxIdx) + 1
                 + n - Math.max(minIdx, maxIdx);

        return Math.min(front, Math.min(back, both));

    }
}