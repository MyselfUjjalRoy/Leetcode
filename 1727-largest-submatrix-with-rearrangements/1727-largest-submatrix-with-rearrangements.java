class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(matrix[r][c] != 0 && r > 0){
                    matrix[r][c] += matrix[r - 1][c];
                }
            }
            int[] currRow = matrix[r].clone();
            Arrays.sort(currRow);
            
            for(int i = 0; i < n; i++){
                int base = n - i;
                int height = currRow[i];
                maxArea = Math.max(maxArea , base * height);
            }
        }
        return maxArea;
    }
}