class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int mask = 1;
        while(mask <= n){
            mask = mask << 1;
        } /// for 5 = 101 -> 100
        mask = mask - 1; // 100 - 1 = 111

        return n ^ mask; // 111 ^ 101 = 010
    }
}