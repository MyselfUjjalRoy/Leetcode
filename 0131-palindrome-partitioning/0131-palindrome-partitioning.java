class Solution {
    public void solve(int i , String s , boolean[][] t , List<String> currPartition , List<List<String>> ans){
        if(i == s.length()){
            ans.add(new ArrayList<>(currPartition));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(t[i][j] == true){ // means pallindrome
                currPartition.add(s.substring(i , j + 1));
                solve(j + 1 , s , t , currPartition , ans);
                currPartition.remove(currPartition.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();

        boolean[][] t = new boolean[n][n];
        // t[i][j] -> true : s[i ... j] is pallindrome

        for(int i = 0; i < n; i++){
            t[i][i] = true;
        }

        for(int length = 2; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;

                if(s.charAt(i) == s.charAt(j)){
                    if(length == 2){
                        t[i][j] = true;
                    }
                    else{
                        t[i][j] = t[i + 1][j - 1];
                    }
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> currPartition = new ArrayList<>();

        solve(0 , s , t , currPartition , ans);

        return ans;
    }
}