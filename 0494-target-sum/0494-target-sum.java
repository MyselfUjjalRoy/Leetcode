class Solution {
    public int findTargetSumWays(int[] nums, int diff) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }

        if((total - diff) % 2 != 0  || (total - diff) < 0) return 0;

        int target = (total - diff) / 2;

        int[] prev = new int[target + 1];

        if(nums[0] == 0){
            prev[0] = 2;
        }
        else{
            prev[0] = 1;
            if(nums[0] <= target){
                prev[nums[0]] = 1;
            }
        }

        for(int i = 1; i < n; i++){
            int[] curr = new int[target + 1];
            for(int t = 0; t <= target; t++){
                int skip = prev[t];
                int take = 0;
                if(nums[i] <= t){
                    take = prev[t - nums[i]];
                }

                curr[t] = take + skip;
            }
            prev = curr.clone();
        }

        return prev[target];
    }
}