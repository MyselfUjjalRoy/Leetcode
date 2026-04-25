class Solution {
    public int compareBitonicSums(int[] nums) {
        int idx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                idx = i;
                break;
            }
        }

        long aSum = 0;
        for(int i = 0; i <= idx; i++){
            aSum += nums[i];
        }

        long dSum = 0;
        for(int i = idx; i < nums.length; i++){
            dSum += nums[i];
        }

        if(aSum > dSum){
            return 0;
        }
        else if(aSum < dSum){
            return 1;
        }
        else{
            return -1;
        }
    }
}