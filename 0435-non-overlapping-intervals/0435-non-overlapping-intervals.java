class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        // sort by end time
        Arrays.sort(intervals , (a , b) -> Integer.compare(a[1] , b[1])); 

        int prevEnd = intervals[0][1];

        int removed = 0;

        for(int i = 1; i < n; i++){
            int[] curr = intervals[i];

            if(curr[0] < prevEnd){
                removed++;
            }
            else{
                prevEnd = curr[1];
            }
        }

        return removed;
    }
}