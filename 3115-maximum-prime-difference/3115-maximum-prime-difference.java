class Solution {
     public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) { 
            if (num % i == 0) return false;
        }
        return true;
    }
    public int maximumPrimeDifference(int[] nums) {
        int n=nums.length;
        int startIndex=0;
        int lastIndex=0;
        for(int i=0;i<n;i++){
            if(isPrime(nums[i])){
                startIndex=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(isPrime(nums[i])){
                lastIndex=i;
                break;
            }
        }
        return lastIndex-startIndex;
    }
}