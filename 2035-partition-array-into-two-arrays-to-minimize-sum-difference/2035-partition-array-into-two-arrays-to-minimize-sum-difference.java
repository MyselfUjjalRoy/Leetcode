class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        Map<Integer , List<Integer>> leftMap = getSums(nums , 0 , n- 1);
        Map<Integer , List<Integer>> rightMap = getSums(nums , n , 2 * n - 1);

        int total = 0;
        for(int num : nums) total += num;

        for(List<Integer> list : rightMap.values()){
            Collections.sort(list);
        }

        int ans = Integer.MAX_VALUE;
        for(int k = 0; k <= n; k++){
            List<Integer> leftList = leftMap.get(k);
            List<Integer> rightList = rightMap.get(n - k);

            for(int sumL : leftList){
                int target = total / 2 - sumL;

                int idx = lowerBound(rightList, target);

                if(idx < rightList.size()){
                    int sumR = rightList.get(idx);
                    int S = sumL + sumR;
                    ans = Math.min(ans , Math.abs(S - (total - S)));
                }
                if(idx > 0){
                    int sumR = rightList.get(idx - 1);
                    int S = sumL + sumR;
                    ans = Math.min(ans , Math.abs(S - (total - S)));
                }
            }
        }
        return ans;
    }
    private Map<Integer , List<Integer>> getSums(int[] nums , int start , int end){
        Map<Integer , List<Integer>> map = new HashMap<>();
        int len = end - start + 1;

        for(int mask = 0; mask < (1 << len); mask++){
            int sum = 0;
            int count = 0;
            for(int i = 0; i < len; i++){
                if((mask & (1 << i)) != 0){
                    sum += nums[start + i];
                    count++;
                }
            }
            map.putIfAbsent(count , new ArrayList<>());
            map.get(count).add(sum);
        }

        return map;
    }

    public int lowerBound(List<Integer> list , int target){
        int low = 0 , high = list.size() - 1;
        int ans = list.size();
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(list.get(mid) >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}