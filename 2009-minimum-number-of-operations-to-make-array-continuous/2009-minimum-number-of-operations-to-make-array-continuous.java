class Solution {
    public int minOperations(int[] nums) {
        int newNums[] = Arrays.stream(nums).distinct().sorted().toArray();
        int n = nums.length;
        int ans = n;
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < newNums.length && newNums[j] < newNums[i] + n){
                j++;
            }
            int inRange = j - i;
            int outRange = n - inRange;
            ans = Math.min(ans , outRange);
        }
        return ans;
    }
}