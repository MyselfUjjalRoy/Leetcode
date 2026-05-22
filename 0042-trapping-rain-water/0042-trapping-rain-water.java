class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        int maxWater = 0;

        int[] leftMax = new int[n];
        leftMax[0] = heights[0];

        int[] rightMax = new int[n];
        rightMax[n - 1] = heights[n - 1];

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(heights[i] , leftMax[i - 1]);
        }

        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(heights[i] , rightMax[i + 1]);
        }

        for(int i = 0; i < n; i++){
            maxWater += Math.max(Math.min(leftMax[i] , rightMax[i]) - heights[i] , 0);
        }

        return maxWater;
    }
}