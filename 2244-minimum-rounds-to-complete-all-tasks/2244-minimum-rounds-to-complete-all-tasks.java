class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int task : tasks){
            map.put(task , map.getOrDefault(task , 0) + 1);
        }
        int rounds = 0;
        for(int val : map.values()){
            if(val == 1) return -1;
            if(val % 3 == 0){
                rounds += val / 3;
            }
            else{
                rounds += val / 3 + 1;
            }
        }
        return rounds;
    }
}