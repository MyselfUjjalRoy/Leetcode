class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        
        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx , -1);

        int lastIdx = 0;
        int maxLen = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = Math.max(dp[i] , 1 + dp[j]);
                        prevIdx[i] = j;

                        if(dp[i] > maxLen){
                            maxLen = dp[i];
                            lastIdx = i;
                        }
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(lastIdx != -1){
            list.add(nums[lastIdx]);
            lastIdx = prevIdx[lastIdx];
        }

        return list;
    }
}