class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0, total = 0;

        while(left < right){
            if(height[left] <= height[right]){
                if(leftMax > height[left]){
                    total += leftMax - height[left];
                }
                else{
                    leftMax = height[left];
                }
                left = left + 1;
            }
            else{
                if(rightMax > height[right]){
                    total += rightMax - height[right];
                }
                else{
                    rightMax = height[right];
                }
                right = right - 1;
            }
        }
        return total;
    }
}