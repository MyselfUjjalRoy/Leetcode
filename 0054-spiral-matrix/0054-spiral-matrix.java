class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        List<Integer> list = new ArrayList<>();

        while(top <= bottom && left <= right){
            // left to right
            for(int j = left; j <= right; j++){
                list.add(matrix[top][j]);
            }   
            top++;

            // top to bottom
            for(int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;

            // right to left
            if(top <= bottom){ // single row - [1 2 3]
                for(int j = right; j >= left; j--){
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // bottom to top
            if(left <= right){ // single col - [[1] , [2] , [3]]
                for(int i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}