class Solution {

    public boolean checkPalindrome(int i , int j , String s){
        if(i > j){
            return true;
        }
        if(s.charAt(i) == s.charAt(j)){
            return checkPalindrome(i + 1 , j - 1 , s);
        }

        return false;
    }
    public int countSubstrings(String s) {
        int n = s.length();

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(checkPalindrome(i , j , s)){
                    count++;
                }
            }
        }

        return count;
    }
}