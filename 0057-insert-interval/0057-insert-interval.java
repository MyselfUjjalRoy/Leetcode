class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();

        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        while(i < n){
            list.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[list.size()][2];
        for(int k = 0; k < list.size(); k++){
            ans[k] = list.get(k);
        }

        return ans;
    }
}