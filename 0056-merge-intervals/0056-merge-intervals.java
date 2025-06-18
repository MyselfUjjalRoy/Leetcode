class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] <= prev[1]){
                prev[1] = Math.max(curr[1] , prev[1]);
            }
            else{
                merged.add(prev);
                prev = curr;
            }
        }
        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
}