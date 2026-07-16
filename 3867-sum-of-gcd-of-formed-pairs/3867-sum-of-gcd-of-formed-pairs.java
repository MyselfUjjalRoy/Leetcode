class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int maxEle = Integer.MIN_VALUE;
        int[] max = new int[n];
        int[] prefixGCD = new int[n];
        
        for(int i = 0; i < n; i++){
            maxEle = Math.max(maxEle , nums[i]);
            max[i] = maxEle;
            prefixGCD[i] = gcd(nums[i] , max[i]);
        }

        System.out.println(Arrays.toString(max));
        System.out.println(Arrays.toString(prefixGCD));

        Arrays.sort(prefixGCD);

        int i = 0 , j = n - 1;
        long sum = 0;

        while(i < j){
            sum += gcd(prefixGCD[i] , prefixGCD[j]);
            i++;
            j--;
        }

        return sum;
    }

    public int gcd(int a , int b){
        return b == 0 ? a : gcd(b , a % b);
    }
}