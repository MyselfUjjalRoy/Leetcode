class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int[] t = new int[n];
        Arrays.fill(t , 1);

        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx , -1);

        int maxLen = 1;
        int lastIndex = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    t[i] = 1 + t[j];
                    prevIdx[i] = j;
                }
            }

            if(maxLen < t[i]){
                maxLen = t[i];
                lastIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();

        while(lastIndex != -1){
            list.add(nums[lastIndex]);
            lastIndex = prevIdx[lastIndex];
        }

        return list;
    }
}