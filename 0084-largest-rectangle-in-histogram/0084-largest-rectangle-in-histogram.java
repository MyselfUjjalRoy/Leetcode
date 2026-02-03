class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int element = stack.peek();
                stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea , (nse - pse -1) * heights[element]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int element = stack.peek();
            stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea , (nse - pse -1) * heights[element]);
        }
        return maxArea;
    }
}