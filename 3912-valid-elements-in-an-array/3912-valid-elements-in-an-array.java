class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = -1;
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1] , nums[i - 1]);
        }

        rightMax[n - 1] = -1;
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1] , nums[i + 1]);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(nums[i] > leftMax[i] || nums[i] > rightMax[i]){
                list.add(nums[i]);
            }
        }

        return list;
    }
}