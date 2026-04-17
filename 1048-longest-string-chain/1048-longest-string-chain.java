class Solution {
    int n;
    int[][] t;
    public int solve(int prevIdx , int currIdx , String[] words){
        if(currIdx == n){
            return 0;
        }

        if(prevIdx != -1 && t[prevIdx][currIdx] != -1){
            return t[prevIdx][currIdx];
        }

        int take = 0;
        if(prevIdx == -1 || isPredecessor(words[prevIdx] , words[currIdx])){
            take = 1 + solve(currIdx , currIdx + 1 , words);
        }
        
        int notTake = solve(prevIdx , currIdx + 1 , words);

        if(prevIdx != -1) t[prevIdx][currIdx] = Math.max(take , notTake);

        return Math.max(take , notTake);
    }

    public boolean isPredecessor(String prev , String curr){
        if(curr.length() - prev.length() != 1) return false;

        int m = prev.length() , n = curr.length();

        int i = 0 , j = 0;

        while(i < m && j < n){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            j++;
        }

        return i ==m;
    }
    public int longestStrChain(String[] words) {
        n = words.length;

        Arrays.sort(words , (a , b) -> a.length() - b.length());

        t = new int[n + 1][n + 1];

        for(int i = 0; i < n; i++){
            Arrays.fill(t[i] , -1);
        }

        return solve(-1 , 0 , words);
    }
}