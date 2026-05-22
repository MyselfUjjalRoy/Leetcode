class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        int maxWater = 0;

        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = n - 1;

        while(left < right){
            if(leftMax < heights[left]){
                leftMax = heights[left];
            }
            if(rightMax < heights[right]){
                rightMax = heights[right];
            }

            if(leftMax < rightMax){
                maxWater += Math.max(leftMax - heights[left] , 0);
                left++;
            }
            else{
                maxWater += Math.max(rightMax - heights[right] , 0);
                right--;
            }
        }

        return maxWater;
    }
}