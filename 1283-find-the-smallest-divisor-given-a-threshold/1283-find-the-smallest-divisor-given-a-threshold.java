class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int minDivisor = 1;
        int maxDivisor = -1;
        for(int num : nums){
            maxDivisor = Math.max(maxDivisor , num);
        }

        while(minDivisor < maxDivisor){
            int mid = minDivisor + (maxDivisor - minDivisor) / 2;
            
            if(canMaintainThreshold(nums , mid , threshold)){
                maxDivisor = mid;
            }
            else{
                minDivisor = mid + 1;
            }
        }
        return minDivisor;
    }
    public boolean canMaintainThreshold(int[] nums , int divisor , int threshold){
        int divisorSum = 0;
        for(int num : nums){
            divisorSum += Math.ceil(num*1.0 / divisor);
        }
        return divisorSum <= threshold;
    }
}