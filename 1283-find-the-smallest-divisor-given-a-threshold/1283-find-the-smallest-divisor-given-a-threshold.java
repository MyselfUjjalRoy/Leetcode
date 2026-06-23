class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 1;
        for(int num : nums){
            high = Math.max(high , num);
        }

        int ans = 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isValid(mid , threshold , nums)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean isValid(int divisor , int threshold , int[] nums){
        int sum = 0;

        for(int num : nums){
            sum = sum + (num + divisor - 1) / divisor;
        }

        return sum <= threshold;
    }
}