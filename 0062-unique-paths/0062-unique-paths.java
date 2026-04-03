class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m][n];

        for(int i = 0; i < m; i++){
            t[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            t[0][j] = 1;
        }

       // t[0][0] = 0;  if m = 1 , n = 1 then also ans = 1 ,not 0 , the written condition will be false

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                t[i][j] = t[i - 1][j] + t[i][j - 1];
            }
        }

        return t[m - 1][n - 1];
    }
}