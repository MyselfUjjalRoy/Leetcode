class Solution {
    public int removePalindromeSub(String s) {
        if(isPallindrome(s))
        {
            return 1;
        }
       return 2;
    }
    public boolean isPallindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}