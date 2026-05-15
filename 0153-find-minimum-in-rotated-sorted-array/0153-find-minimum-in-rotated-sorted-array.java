class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){ // if I use <= then infinite loop
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]){ // that means mid cannot be the answer
                left = mid + 1;    
            }
            else{ // as it is <= so i just simply can't do right = mid - 1 , mid can also be the answer
                right = mid;
            }
        }

        return nums[left];
    }
}