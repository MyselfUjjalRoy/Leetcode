class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.merge(num , 1 , Integer:: sum);
        }
        for(int key : map.keySet()){
            if(map.get(key) == n){
                return key;
            }
        }
        return -1;
    }
}