class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;

        int minCost = 0;
        for(int i = n - 1; i >= 0; i -= 3){
            minCost += cost[i] + (((i - 1) >= 0) ? cost[i - 1] : 0);

        }

        return minCost;
    }
}