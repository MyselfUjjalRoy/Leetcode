class Solution {
    int[] dp;
    public int fib(int n) {
        if(n == 0) return 0; 
        dp = new int[n + 1];
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}