class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;

        for(int num = num1; num <= num2; num++){
            String value = String.valueOf(num);
            if(value.length() < 3) continue;
            for(int i = 1; i < value.length() - 1; i++){
                int prevNum = value.charAt(i - 1) - '0';
                int currNum = value.charAt(i) - '0';
                int nextNum = value.charAt(i+ 1) - '0';

                if(currNum > prevNum && currNum > nextNum){
                    waviness++;
                }
                if(currNum < prevNum && currNum < nextNum){
                    waviness++;
                }
            }
        }

        return waviness;
    }
}