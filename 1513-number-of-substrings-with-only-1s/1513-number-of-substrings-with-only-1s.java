class Solution {
    public int numSub(String s) {
        long count = 0;
        long ans = 0;
        long MOD = 1_000_000_007L;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }
            else{
                ans += (count * (count + 1) / 2) % MOD;
                count = 0;
            }
        }
        ans += (count * (count + 1) / 2) % MOD;
        return (int)ans;
    }
}