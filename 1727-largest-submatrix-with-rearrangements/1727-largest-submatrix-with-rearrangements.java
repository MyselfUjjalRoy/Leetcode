class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<int[]> prevHeights = new ArrayList<>();
        int maxArea = 0;

        for(int r = 0; r < m; r++){
            ArrayList<int[]> heights = new ArrayList<>();
            boolean[] seen = new boolean[n];
            for(int[] entry : prevHeights){
                int height = entry[0];
                int col = entry[1];
                if(matrix[r][col] == 1){
                    heights.add(new int[]{height + 1 , col});
                    seen[col] = true;
                }
            }

            for(int col = 0; col < n; col++){
                if(!seen[col] && matrix[r][col] == 1){
                    heights.add(new int[]{1 , col});
                }
            }

            for(int i = 0; i < heights.size(); i++){
                int base = i + 1;
                int height = heights.get(i)[0];
                maxArea = Math.max(maxArea , base * height);
            }
            prevHeights = heights;
        }
        return maxArea;
    }
}