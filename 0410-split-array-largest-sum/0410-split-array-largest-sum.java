class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num : nums){
            low = Math.max(low , num);
            high += num;
        }

        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canSplit(mid , k , nums)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canSplit(int maxSum , int k , int[] nums){
        int split = 1;
        int currSum = 0;

        for(int num : nums){
            currSum += num;
            if(currSum > maxSum){
                split++;
                currSum = num;
            }
            if(split > k){
                return false;
            }
        }

        return true;
    }
}