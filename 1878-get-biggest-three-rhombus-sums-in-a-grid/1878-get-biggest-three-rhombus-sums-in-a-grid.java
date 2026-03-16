class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                addToSet(grid[r][c] , set);

                for(int side = 1; r - side >= 0 && r + side < m && c + side < n && c - side >= 0; side++){
                    int sum = 0;
                    for(int k = 0; k < side; k++){
                        sum += grid[r - side + k][c + k];//top to right corner
                        sum += grid[r + k][c + side - k];//right to bottom corner
                        sum += grid[r + side - k][c - k];//bottom to left corner
                        sum += grid[r - k][c - side + k];//left to top corner
                    }
                    addToSet(sum , set);
                }
            }
        }
        return buildAnswer(set);
    }
    public void addToSet(int val , TreeSet<Integer> set){
        set.add(val);

        if(set.size() > 3){
            set.pollFirst();
        }
    }
    public int[] buildAnswer(TreeSet<Integer> set){
        int[] res = new int[set.size()];
        int idx = 0;

        Iterator<Integer> it = set.descendingIterator();
        while(it.hasNext()){
            res[idx++] = it.next();
        }

        return res;
    }
}