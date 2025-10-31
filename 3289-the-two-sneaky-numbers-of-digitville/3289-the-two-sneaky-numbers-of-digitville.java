class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        for(int num : map.keySet()){
            if(map.get(num) > 1){
                list.add(num);
            }
        }
        int n = list.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}