class Solution {
    int[][] t;
    int n;
    public int longestStrChain(String[] words) {
        n = words.length;
        Arrays.sort(words , (a , b) -> a.length() - b.length());

        t = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(t[i] , -1);
        }

        return lis(words , -1 , 0);
    }

    public int lis(String[] words , int prevIdx , int currIdx){
        if(currIdx == n){
            return 0;
        }

        if(prevIdx != -1 && t[prevIdx][currIdx] != -1){
            return t[prevIdx][currIdx];
        }

        int take = 0;
        if(prevIdx == -1 || isPredecessor(words[prevIdx] , words[currIdx])){
            take = 1 + lis(words , currIdx , currIdx + 1);
        }

        int skip = lis(words , prevIdx , currIdx + 1);

        if(prevIdx != -1){
            t[prevIdx][currIdx] = Math.max(take , skip);
        }

        return Math.max(take , skip);
    }

    public boolean isPredecessor(String prev , String curr){
        if((curr.length() - prev.length()) != 1){
            return false;
        }
        int m = prev.length() , n = curr.length();
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