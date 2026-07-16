class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words , (a , b) -> a.length() - b.length());

        int maxLen = 1;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(isPredecessor(words[j] , words[i])){
                    dp[i] = Math.max(dp[i] , 1 + dp[j]);
                    maxLen = Math.max(maxLen , dp[i]);
                }
            }
        }

        return maxLen;
    }

    public boolean isPredecessor(String word1 , String word2){
        int m = word1.length();
        int n = word2.length();

        if(n - m != 1) return false;

        int i = 0 , j = 0;

        while(i < m && j < n){
            if(word1.charAt(i) == word2.charAt(j)){
                i++;
            }
            j++;
        }

        return i == m;
    }
}