class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int alice = n - 1;
        int me = n - 2;
        int bob = 0;
        int coins = 0;
        while(me > bob){
            coins += piles[me];
            me -= 2;
            bob += 1;
            alice -= 2;// this line is not required, written for understanding purpose
        }
        return coins;
    }
}