class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(helper(answerKey,k,'T'),helper(answerKey,k,'F'));
    }
    public int helper(String answerKey,int k,char ch){
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end < answerKey.length()){
            char curr = answerKey.charAt(end);
            if(curr != ch){
                k--;
            }
            while(k < 0){
                if(answerKey.charAt(start) == ch){
                    start++;
                }
                else{
                    k++;
                    start++;
                }
            }
            ans = Math.max(ans , end - start + 1);
            end++;
        }
        return ans;
    }
}