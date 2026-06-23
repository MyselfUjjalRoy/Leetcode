class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = -1;
        int maxCapacity = 0;

        for(int weight : weights){
            minCapacity = Math.max(minCapacity , weight);
            maxCapacity += weight;
        }

        int ans = -1;

        while(minCapacity <= maxCapacity){
            int mid = minCapacity + (maxCapacity - minCapacity) / 2;

            if(isPossible(mid , days , weights)){
                ans = mid;
                maxCapacity = mid - 1;
            }
            else{
                minCapacity = mid + 1;
            }
        }

        return ans;
    }

    public boolean isPossible(int capacity , int D , int[] weights){
        int weight = 0;
        int days = 1;

        for(int w : weights){
            if(weight + w > capacity){
                days++;
                weight = 0;
            }
            weight += w;
        } 

        return days <= D;
    }
}