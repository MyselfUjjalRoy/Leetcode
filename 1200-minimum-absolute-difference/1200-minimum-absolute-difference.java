class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            minDifference = Math.min(minDifference , Math.abs(arr[i] - arr[i + 1]));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            List<Integer> curr = new ArrayList<>();
            if(Math.abs(arr[i] - arr[i+1]) == minDifference){
                curr.add(arr[i]);
                curr.add(arr[i + 1]);
                ans.add(curr);
            }
            
        }
        return ans;
    }
}