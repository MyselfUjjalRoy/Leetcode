class Solution {
    int n;
    int[][] dp;
    public int longestStrChain(String[] words) {
        n = words.length;
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
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

        // take
        int take = 0;
        if(prevIdx == -1 || isPredecessor(words[prevIdx] , words[currIdx])){
            take = 1 + solve(currIdx , currIdx + 1 , words);
        }

        // skip

        int skip = solve(prevIdx , currIdx + 1 , words);

        if(prevIdx != -1){
            dp[prevIdx][currIdx] = Math.max(take , skip);
        }

        return Math.max(take , skip);
    }

    public boolean isPredecessor(String prev , String curr){
        int m = prev.length();
        int n = curr.length();

        if(n - m != 1) return false;

        int i = 0 , j = 0;

        while(i < m && j < n){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            j++;
        }

        return i == m;
    }
}