class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth=0;
        for(int[] arr:accounts){
            int wealth=0;
            for(int ele:arr){
                wealth+=ele;
            }
            maxWealth=Math.max(wealth,maxWealth);
        }
        return maxWealth;
    }
}