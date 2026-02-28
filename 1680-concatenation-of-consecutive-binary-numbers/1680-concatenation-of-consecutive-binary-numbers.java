class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long result = 0;
        for(int i = 1; i <= n; i++){
            int len = 32 - Integer.numberOfLeadingZeros(i);
            result = ((result << len) | i) % MOD;
        }
        return (int)result;
    }
}