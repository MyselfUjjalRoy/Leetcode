class Solution {
    public int solve(int num){
        if(num == 0) return 0;
        int remain = solve(num / 10);
        int digit = num % 10;

        int digit_check;   
        if(digit == 0 || digit == 1 || digit == 8) digit_check = 0;
        else if(digit == 2 || digit == 5 || digit == 6 || digit == 9) digit_check = 1;
        else return 2;

        if(remain == 0 && digit_check == 0){
            return 0;
        }
        else if(remain == 2 || digit_check == 2){
            return 2;
        }
        else return 1; // means valid change found        
    }
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(solve(i) == 1){
                count++;
            }
        }

        return count;
    }
}