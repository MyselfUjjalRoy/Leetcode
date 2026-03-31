class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            int idx = lowerBound(list , num);

            if(idx == list.size()){
                list.add(num);
            }
            else{
                list.set(idx , num);
            }
        }

        return list.size();
    }

    public int lowerBound(ArrayList<Integer> list , int target){
        int left = 0 , right = list.size() - 1;
        int ans = list.size();

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(list.get(mid) >= target){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return ans;
    }
}