class Solution {
    /*
     just reused the function of largest rectange histogram
     and then passed the heights array for each row of the matrix and calculate the
     maximal rectangle
     
    */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                
            int element = stack.pop();
            int nse = i;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max((nse - pse - 1) * heights[element] , maxArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int element = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea , (nse - pse - 1) * heights[element]);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] != '0') heights[j] += 1;
                else heights[j] = 0;
            }

            int area = largestRectangleArea(heights);

            ans = Math.max(ans , area);
        }

        return ans;
    }
}