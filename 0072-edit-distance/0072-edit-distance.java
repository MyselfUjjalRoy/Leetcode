class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n + 1];

        for(int i = 0; i < m + 1; i++){
            int[] curr = new int[n + 1];
            for(int j = 0; j < n + 1; j++){
                if(i == 0 || j == 0){
                    curr[j] = i + j;
                }
                else if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    curr[j] = prev[j - 1];
                }
                else{
                    int insert = curr[j - 1] + 1;
                    int delete = prev[j] + 1;
                    int replace = prev[j - 1] + 1;

                    curr[j] = Math.min(insert , Math.min(delete , replace));
                }
            }
            prev = curr;
        }

        return prev[n];
    }
}