class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);

        for (int t = 0; t < k; t++) {
            int[][] next = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int newI = i;
                    int newJ = j + 1;
                    if(newJ == n){
                        newJ = 0;
                        newI++;
                    }
                    if(newI == m){
                        newI = 0;
                    }

                    next[newI][newJ] = grid[i][j];
                }
            }
            grid = next;
        }
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int[] row : grid){
            List<Integer> newRow = new ArrayList<>();
            for(int val : row){
                newRow.add(val);
            }
            list.add(newRow);
        }

        return list;
    }
}