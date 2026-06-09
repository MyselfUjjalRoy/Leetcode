class Solution {
    int n;
    int[][] dp;
    public int longestStrChain(String[] words) {
        n = words.length;
        dp = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        Arrays.sort(words , (a , b) -> a.length() - b.length());

        return solve(-1 , 0 , words);
    }

    public int solve(int prevIdx , int currIdx , String[] words){
        if(currIdx >= n){
            return 0;
        }

        if(prevIdx != -1 && dp[prevIdx][currIdx] != -1){
            return dp[prevIdx][currIdx];
        }

        int take = 0;
        if(prevIdx == -1 || isPredecessor(words[prevIdx] , words[currIdx])){
            take = 1 + solve(currIdx , currIdx + 1 , words);
        }

        int skip = solve(prevIdx , currIdx + 1 , words);

        int ans = Math.max(take , skip);

        if(prevIdx != -1){
            dp[prevIdx][currIdx] = ans;
        }

        return ans;
    }

    public boolean isPredecessor(String prevWord , String currWord){
        if(currWord.length() - prevWord.length() != 1) return false;

        int i = 0 , j = 0;
        int len1 = prevWord.length() , len2 = currWord.length();

        while(i < len1 && j < len2){
            if(prevWord.charAt(i) == currWord.charAt(j)){
                i++;
            }
            j++;
        }

        return i == len1;
    }
}