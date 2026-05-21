class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums , k) - atMost(nums , k - 1);
    }

    public int atMost(int[] nums , int k){
        int n = nums.length;
        Map<Integer , Integer> map = new HashMap<>();

        int i = 0 , j = 0;
        int count = 0;

        while(j < n){
            map.put(nums[j] , map.getOrDefault(nums[j] , 0) + 1);

            while(map.size() > k){
                int val = nums[i];
                map.put(val , map.get(val) - 1);
                if(map.get(val) == 0) map.remove(val);
                i++;
            }

            count += j - i + 1;
            j++;
        }
        
        return count;
    }
}