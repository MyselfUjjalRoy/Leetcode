class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            int idx = lowerBound(num , list);
            if(idx == list.size()){
                list.add(num);
            }
            else{
                list.set(idx , num);
            }
        }

        return list.size();
    }

    public int lowerBound(int num , ArrayList<Integer> list){
        int low = 0;
        int high = list.size() - 1;
        int ans = list.size();

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(list.get(mid) >= num){
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