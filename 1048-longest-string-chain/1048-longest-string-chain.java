class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        
        Arrays.sort(words , (a , b) -> a.length() - b.length());

        int[] dp = new int[n];
        Arrays.fill(dp , 1);

        int maxLen = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(isPredecessor(words[j] , words[i])){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];
                        maxLen = Math.max(maxLen , dp[i]);
                    }
                }
            }
        }

        return maxLen;
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