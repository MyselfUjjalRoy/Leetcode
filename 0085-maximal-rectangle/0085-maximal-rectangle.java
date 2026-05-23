class Solution {
    public int largestRectangleHistogram(int[] heights){
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int eleIdx = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea , heights[eleIdx] * (nse - pse - 1));
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int eleIdx = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea , heights[eleIdx] * (nse - pse - 1));
        }

        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];

        int maxArea = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] - '0' == 1) heights[j] += 1;
                else heights[j] = 0;
            }

            int area = largestRectangleHistogram(heights);
            maxArea = Math.max(maxArea , area);
        }

        return maxArea;
    }
}