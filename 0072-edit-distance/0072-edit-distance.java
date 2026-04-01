class Solution {
    int m , n ;
    int[][] dp;

    public int solve(String word1 , String word2 , int i , int j){
        if(i == m){
            return n - j;// so i need to insert char in word1
        }
        else if(j == n){
            return m - i; // so i need to delete some chars from word1
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = solve(word1 , word2 , i + 1 , j + 1);
        }
        else{
            int insertChar = 1 + solve(word1 , word2 , i , j + 1);
            int deleteChar = 1 + solve(word1 , word2 , i + 1, j);
            int replaceChar = 1 + solve(word1 , word2 , i + 1 , j + 1);

            return dp[i][j] = Math.min(Math.min(insertChar , deleteChar) , replaceChar);
        }
    }
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        dp = new int[m + 1][n + 1];

        for(int i = 0; i < m + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(word1 , word2 , 0 , 0);
    }
}