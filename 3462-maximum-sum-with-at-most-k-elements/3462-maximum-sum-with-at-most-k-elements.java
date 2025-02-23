class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
     List<Integer> list = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
            for (int j = grid[i].length - 1; j >= grid[i].length - limits[i]; j--) {
                list.add(grid[i][j]);
            }
        }

        list.sort(Collections.reverseOrder());

        long maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += list.get(i);
        }

        return maxSum;   
    }
}