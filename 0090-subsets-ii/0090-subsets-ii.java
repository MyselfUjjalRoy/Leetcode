class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        findSubSets(0, nums, new ArrayList<>());
        return res;
    }
    public void findSubSets(int index , int[] nums , List<Integer> subList){
        if(index == nums.length){
            if(!set.contains(subList)){
                res.add(new ArrayList<>(subList));
                set.add(subList);
            }
            return;
        }
        subList.add(nums[index]);
        findSubSets(index + 1 , nums , subList);

        subList.remove(subList.size() - 1);
        findSubSets(index + 1 , nums , subList);
    }
}