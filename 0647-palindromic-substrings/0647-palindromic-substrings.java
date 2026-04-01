class Solution {
    int[][] t;
    public int checkPalindrome(int i , int j , String s){
        if(i > j){
            return 1;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){
            return t[i][j] = checkPalindrome(i + 1 , j - 1 , s);
        }

        return 0;
    }
    public int countSubstrings(String s) {
        int n = s.length();

        t = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(t[i] , -1);
        }

        /*
        t[i] = -1 // not calculated
        t[i] = 0 // false
        t[i] = 1 // true
        */

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(checkPalindrome(i , j , s) == 1){
                    count++;
                }
            }
        }

        return count;
    }
}