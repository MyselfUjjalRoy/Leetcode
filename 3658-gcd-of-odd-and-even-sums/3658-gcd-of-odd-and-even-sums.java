class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = 0 , even = 0;

        for(int i = 1; i <= 2 * n; i++){
           if(i % 2 == 1) odd += i;
           else even += i;
        }
        System.out.println(odd);
        System.out.println(even);
        return gcd(odd , even);
    }

    public int gcd(int a , int b){
        return b == 0 ? a : gcd(b , a % b);
    }
}