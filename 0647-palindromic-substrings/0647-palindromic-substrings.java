class Solution {
    /* approach 4
    first option -> assume the i th charcter is the center and making odd length pallindrome
    sencod option -> assume the i th character + (i + 1)th character is the center and making even length pallindrome
    */
    int count;
    
    public void check(int i , int j , String s , int n){
        while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            count++;
        }
    }
    public int countSubstrings(String s) {
        int n = s.length();

        count = 0;

        for(int i = 0; i < n; i ++){
            check(i , i , s , n); // to check odd length pallidrome
            check(i , i + 1 , s , n);// to check even length pallindrome
        }

        return count;
    }
}