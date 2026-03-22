class Solution {
    /*
    to rotate matric 90 degree clock wise -> 
        brute force :- make a new matrix and mat[i][j]→new[j][n−1−i]
    
        optimal idea :- in place
        1. transpose the matrix 
        2. then rev each row
    to rotate 90 degree anti clockwise ->
        1.transpose the matrix 
        2.then rev each column
    */
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int c = 1; c <= 4; c++) { // we will rotate for 4 times , if not possible then return false
            boolean allSame = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != target[i][j]) {
                        allSame = false;
                        break;
                    }
                }
                if (!allSame) {
                    break;
                }
            }
            if (allSame) {
                return true;
            } else {
                rotate(mat);
            }
        }
        return false;
    }
    public void rotate(int[][] mat){
        int n = mat.length;

        // transpose the matrix
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){ // note :- the inner loop will start from i , not from 0 . If we start from 0 then some element will be double reversed , means become like prev
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // rev each row
        for(int i = 0; i < n; i++){
            int left = 0 , right = n - 1;
            while(left < right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}