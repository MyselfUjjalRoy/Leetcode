class Solution {
    public long countSubarrays(int[] nums, int k) {
        long maxElement = 0;
        for(int num : nums){
            maxElement = Math.max(num,maxElement);
        }
        int left =0;
        long maxElementCount = 0;
        long subArraysCount = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == maxElement){
                maxElementCount++;
            }
            while(maxElementCount == k){
                if(nums[left] == maxElement){
                    left++;
                    maxElementCount--;
                }
                else{
                    left++;
                }
            }
            subArraysCount += left;
        }
        return subArraysCount;
    }
}