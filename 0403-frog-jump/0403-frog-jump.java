class Solution {
    HashMap<Integer , Integer> map;
    int n;
    int[][] t;
    public boolean solve(int[] stones , int curr_stone_index , int prevJump){
        if(curr_stone_index == n - 1){
            return true;
        }

        if(t[curr_stone_index][prevJump] != -1){
            return t[curr_stone_index][prevJump] == 1;
        }

        boolean result = false;

        for(int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++){
            if(nextJump > 0){
                int next_stone = stones[curr_stone_index] + nextJump;

                if(map.containsKey(next_stone)){
                    result = result || solve(stones , map.get(next_stone) , nextJump);
                }
            }
        }

        t[curr_stone_index][prevJump] = (result == true) ? 1 : 0;

        return result;
    }
    public boolean canCross(int[] stones) {
        n = stones.length;

        if(stones[1] != 1){
            return false;
        }

        map = new HashMap<>();
        t = new int[2001][2001];
        for(int i = 0; i < 2001; i++){
            Arrays.fill(t[i] , -1);
        }

        for(int i = 0; i < n; i++){
            map.put(stones[i] , i);
        }

        return solve(stones , 0 , 0);
    }
}