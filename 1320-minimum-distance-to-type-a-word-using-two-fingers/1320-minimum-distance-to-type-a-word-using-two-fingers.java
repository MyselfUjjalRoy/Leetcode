class Solution {
    int[][][] dp = new int[301][27][27];

    public int[] getCoordinate(int pos){
        return new int[]{pos / 6 , pos % 6};
    }

    public int getDistance(int pos1 , int pos2){
        int[] c1 = getCoordinate(pos1);
        int[] c2 = getCoordinate(pos2);
        return Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);
    }

    public int solve(String word , int i , int f1 , int f2){
        if(i == word.length()){
            return 0;
        }

        if(dp[i][f1][f2] != -1){
            return dp[i][f1][f2];
        }

       int curr = word.charAt(i) - 'A';

        // case 1 : when no finger is used , so i will always start with finger 1
        if(f1 == 26 && f2 == 26){
            return dp[i][f1][f2] = solve(word , i + 1 , curr , f2);
        }

        // case 2 : second finger is not used
        if(f2 == 26){
            int moveF2 = solve(word , i + 1 , f1 , curr);

            int moveF1 = solve(word , i + 1 , curr , f2) + getDistance(f1 , curr);

            return dp[i][f1][f2] = Math.min(moveF1 , moveF2);
        }

        // case both fingers used
        int moveF1 = solve(word , i + 1 , curr , f2) + getDistance(f1 , curr);
        int moveF2 = solve(word , i + 1 , f1 , curr) + getDistance(f2 , curr);

        return dp[i][f1][f2] = Math.min(moveF1 , moveF2);
    }
    public int minimumDistance(String word) {
        // finger1 = (x1 , y1) and finger2 = (x2 , y2)

        for(int i = 0; i < 301; i++){
            for(int a = 0; a < 27; a++){
                Arrays.fill(dp[i][a] , -1);
            }
        }
        return solve(word,0,26,26);
    }
}