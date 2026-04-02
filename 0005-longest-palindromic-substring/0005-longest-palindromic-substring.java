class Solution {
    int maxLen;
    int start;
    public void check(int i , int j , String s , int n){
        while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)){
            if(maxLen < j - i + 1){
                maxLen = j - i + 1;
                start = i;
            }
            i--;
            j++;
        }
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        maxLen = 0;
        start = 0;

        for(int i = 0; i < s.length(); i++){
            check(i , i , s , n);
            check(i , i + 1 , s , n);
        }

        return s.substring(start , start + maxLen);
    }
}