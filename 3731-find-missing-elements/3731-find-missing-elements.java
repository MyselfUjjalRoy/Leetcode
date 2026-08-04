class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            list.add(num);
            min = Math.min(min , num);
            max = Math.max(max , num);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = min + 1; i < max; i++){
            if(!list.contains(i)) ans.add(i);
        }

        return ans;
    }
}