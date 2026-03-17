class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prevRow = new int[n];

        int maxArea = 0;

        for(int r = 0; r < m; r++){
            int[] currRow = matrix[r].clone();
            for(int c = 0; c < n; c++){
                if(currRow[c] != 0){
                   currRow[c] += prevRow[c];
                }
            }
            int[] sortedRow = currRow.clone();
            Arrays.sort(sortedRow);
            
            
            for(int i = 0; i < n; i++){
                int base = n - i;
                int height = sortedRow[i];
                maxArea = Math.max(maxArea , base * height);
            }
            prevRow = currRow;
        }
        return maxArea;
    }
}