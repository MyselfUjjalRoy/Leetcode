class Solution {
    int[] t;
    public int solve(int num){
        
        if(num == 0) return t[num] = 0;
        int remain = solve(num / 10);
        int digit = num % 10;

        int digit_check;   
        if(digit == 0 || digit == 1 || digit == 8) digit_check = 0;
        else if(digit == 2 || digit == 5 || digit == 6 || digit == 9) digit_check = 1;
        else return t[num] = 2;

        if(remain == 0 && digit_check == 0){
            return t[num] = 0;
        }
        else if(remain == 2 || digit_check == 2){
            return t[num] = 2;
        }
        else return t[num] = 1; // means valid change found        
    }
    public int rotatedDigits(int n) {
        t = new int[n + 1];
        Arrays.fill(t , -1);

        int count = 0;
        for(int i = 1; i <= n; i++){
            if(solve(i) == 1){
                count++;
            }
        }

        return count;
    }
}