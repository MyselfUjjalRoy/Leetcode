class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        System.out.println(Arrays.toString(prefixSum));

        int[] ans = new int[n];
        ans[0] = prefixSum[n - 1] - nums[0];

        
        for(int i = 1; i < n; i++){
            int leftSum = prefixSum[i - 1];
            int rightSum = prefixSum[n - 1] - prefixSum[i];

            ans[i] = Math.abs(leftSum - rightSum);
        }

        return ans;
    }
}