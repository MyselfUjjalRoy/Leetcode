class Solution {
    int[] dp;
    int MOD = 1_000_000_007;

    public int numberOfArrays(String s, int k) {
        int n = s.length();

        dp = new int[n];
        Arrays.fill(dp , -1);

        return solve(0 , s , k);
    }

    public int solve(int idx , String s , int k){
        if(idx >= s.length()){
            return 1;
        }

        if(s.charAt(idx) == '0'){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        long ans = 0;
        long num = 0;

        for(int end = idx; end < s.length(); end++){
            num = num * 10 + (s.charAt(end) - '0');

            if(num > k){
                break;
            }

            ans = (ans + solve(end + 1 , s , k)) % MOD;
        }

        return dp[idx] = (int)ans;
    }
}