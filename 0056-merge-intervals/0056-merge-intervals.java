class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] prev = intervals[0];
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int[] curr = intervals[i];

            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                list.add(prev);
                prev = curr;
            }
        }

        list.add(prev);

        return list.toArray(new int[list.size()][2]);
    }
}