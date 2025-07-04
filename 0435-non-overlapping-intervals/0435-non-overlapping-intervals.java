class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a , b)-> a[1] - b[1]);
        int lastEnd = intervals[0][1];
        int n = intervals.length;
        int removal = 0;

        for(int i = 1; i < n; i++){
            if(intervals[i][0] < lastEnd){
                removal++;
            }
            else{
                lastEnd = intervals[i][1];
            }
        }
        return removal;
    }
}