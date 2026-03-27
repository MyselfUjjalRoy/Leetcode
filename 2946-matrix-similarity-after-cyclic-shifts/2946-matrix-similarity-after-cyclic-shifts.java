class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k = k % n;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int currIdx = j;
                int futureIdx;

                if(i % 2 == 0){
                    futureIdx = (j + k) % n;
                }
                else{
                    futureIdx = (j - k + n) % n;
                }

                if(mat[i][currIdx] != mat[i][futureIdx]){
                    return false;
                }
            }
        }

        return true;
    }
}