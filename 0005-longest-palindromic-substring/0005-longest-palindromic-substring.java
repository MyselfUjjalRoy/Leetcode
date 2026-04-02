class Solution {
    int[][] t;
    public int check(int i , int j , String s){
        if(i >= j){
            return 1;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){
            return t[i][j] = check(i + 1 , j - 1 , s);
        }
        return t[i][j] = 0;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        t = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(t[i] , -1);
        }

        int maxLen = Integer.MIN_VALUE;
        int start = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(check(i , j , s) == 1){
                    if(maxLen < j - i + 1){
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start , start + maxLen);
    }
}