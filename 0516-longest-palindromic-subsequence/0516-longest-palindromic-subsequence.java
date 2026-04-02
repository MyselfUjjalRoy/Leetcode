class Solution {
    int[][] t;
    public int solve(int i , int j , String s){
        if(i > j){
            return 0;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        if(i == j){
            return 1;
        }
        else if(s.charAt(i) == s.charAt(j)){
            return t[i][j] = 2 + solve(i + 1 , j - 1 , s);
        }
        else{
            return t[i][j] = Math.max(solve(i + 1 , j , s) , solve(i , j - 1 , s));
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        t = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(t[i] , -1);
        }

        return solve(0 , n - 1 , s);
    }
}