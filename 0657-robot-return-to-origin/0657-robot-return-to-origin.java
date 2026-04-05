class Solution {
    public boolean judgeCircle(String moves) {
        int L = 0;
        int R = 0;
        int D = 0;
        int U = 0;

        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                L++;
            }
            else if(ch == 'R'){
                R++;
            }
            else if(ch == 'U'){
                U++;
            }
            else{
                D++;
            }
        }

        return L == R && U == D;
    }
}