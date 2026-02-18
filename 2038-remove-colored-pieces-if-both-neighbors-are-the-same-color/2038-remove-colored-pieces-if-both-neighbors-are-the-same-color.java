class Solution {
    public boolean winnerOfGame(String s) {
        int alice = 0 , bob = 0;
        for(int i = 1; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1)){
                if(s.charAt(i) == 'A'){
                    alice++;
                }
                else{
                    bob++;
                }
            }
        }
        return alice > bob;
    }
}