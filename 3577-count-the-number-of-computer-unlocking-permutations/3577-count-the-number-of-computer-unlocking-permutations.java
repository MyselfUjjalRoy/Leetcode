class Solution {
    static long MOD = 1_000_000_007;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int smallest = complexity[0];
        Map<Integer , Integer> map = new HashMap<>();
        for(int c : complexity){
            smallest = Math.min(c , smallest);
            map.merge(c , 1 , Integer:: sum);
        }
        if(map.get(smallest) > 1 || smallest != complexity[0]) return 0;
        long fact = 1;
        for(int i = 2; i <= n - 1; i++){
            fact = (fact * i) % MOD;
        }
        return (int)fact;
    }
}