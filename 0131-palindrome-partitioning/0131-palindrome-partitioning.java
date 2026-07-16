class Solution {
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();

        dp = new boolean[n + 1][n + 1];

        for(int length = 1; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;
                
                if(i == j) dp[i][j] = true;
                else if(i + 1 == j) dp[i][j] = (s.charAt(i) == s.charAt(j));
                else dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
            }
        }

        List<String> currPartition = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        solve(0 , s , currPartition , ans);

        return ans;
    }

    public void solve(int i , String s , List<String> currPartition , List<List<String>> ans){
        int n = s.length();
        if(i == n){
            ans.add(new ArrayList<>(currPartition));
            return;
        }

        for(int j = i; j < n; j++){
            if(dp[i][j]){
                currPartition.add(s.substring(i , j + 1));
                solve(j + 1 , s , currPartition , ans);
                currPartition.remove(currPartition.size() - 1);
            }
        }
    }
}