class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(0 , 0 , list , ans , candidates , target);

        return ans;
    }

    public void solve(int idx , int currSum , List<Integer> list , List<List<Integer>> ans , int[] candidates , int target){
        if(currSum == target){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(idx == candidates.length || currSum > target){
            return;
        }

        // pick 
        list.add(candidates[idx]);
        currSum += candidates[idx];

        solve(idx , currSum , list , ans , candidates , target);

        list.remove(list.size() - 1);
        currSum -= candidates[idx];

        solve(idx + 1 , currSum , list , ans , candidates , target);
    }
}