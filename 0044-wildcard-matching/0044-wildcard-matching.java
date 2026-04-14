class Solution {
    Boolean[][] dp;
    public boolean solve(int i , int j , String s , String p){
        if(dp[i][j] != null) return dp[i][j];
        
        if(i == 0 && j == 0) return true;
        if(j == 0 && i >= 0) return false;
        if(i == 0 && j >= 0){
            for(int jj = 0; jj < j; jj++){
                if(p.charAt(jj) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
            return dp[i][j] = solve(i - 1 , j - 1 , s , p);
        }
        else if(p.charAt(j - 1) == '*'){
            return dp[i][j] = solve(i - 1 , j , s , p) || solve(i , j - 1 , s , p);
        }

        return false;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        dp = new Boolean[m + 1][n + 1];

        return solve(m , n , s , p);
    }
}