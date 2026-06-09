class Solution {
    /*
    bottom up approach - same as LIS code 
    because top down failed
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] t = new int[n];
        int[] prevIdx = new int[n];

        Arrays.fill(t , 1);
        Arrays.fill(prevIdx , -1);

        int lastIdx = 0;

        int maxLen = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(t[i] < t[j] + 1){
                        t[i] = t[j] + 1;
                        prevIdx[i] = j;
                        if(t[i] > maxLen){
                            maxLen = t[i];
                            lastIdx = i;
                        }
                    }
                }
            }

        }

        List<Integer> ans = new ArrayList<>();
        while(lastIdx != -1){
            ans.add(nums[lastIdx]);
            lastIdx = prevIdx[lastIdx];
        }

        return ans;
    }
}