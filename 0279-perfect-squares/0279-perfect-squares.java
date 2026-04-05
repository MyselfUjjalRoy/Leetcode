//Approach- (Recursion with Memoizatin without Coin Change concept)
//T.C : O(n * sqrt(n))
//S.C : O(n)

// we can solve it with the concept of coin change 
class Solution {
    int[] t;
    public int numSquares(int n) {
        t = new int[n + 1];

        Arrays.fill(t , -1);

        return solve(n);
    }

    public int solve(int n){
        if(n == 0){
            return 0;
        }

        if(t[n] != -1){
            return t[n];
        }
        
        int minCount = Integer.MAX_VALUE;

        for(int i = 1; i * i <= n; i++){
            minCount = Math.min(minCount , 1 + solve(n - i * i)); // 1 for selecting one square number
        }

        return t[n] = minCount;
    }
}