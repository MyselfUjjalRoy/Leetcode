class Solution {
    public int findGCD(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int num : nums){
            mini = Math.min(mini , num);
            maxi = Math.max(maxi , num);
        }

        return gcd(mini , maxi);
    }

    public int gcd(int a , int b){
        return b == 0 ? a : gcd(b , a % b);
    }
}