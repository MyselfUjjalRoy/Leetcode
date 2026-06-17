class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        solve(0 , 0 , target , candidates , list , ans);

        return ans; 
    }

    public void solve(int idx , int currSum , int target , int[] candidates , List<Integer> list , List<List<Integer>> ans){
        if(currSum == target){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(idx == candidates.length || currSum > target){
            return;
        }

        list.add(candidates[idx]);
        currSum += candidates[idx];

        solve(idx + 1 , currSum , target , candidates , list , ans);

        list.remove(list.size() - 1);
        currSum -= candidates[idx];

        while(idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]){
            idx++;
        }

        solve(idx + 1 , currSum , target , candidates , list , ans);
    }
}