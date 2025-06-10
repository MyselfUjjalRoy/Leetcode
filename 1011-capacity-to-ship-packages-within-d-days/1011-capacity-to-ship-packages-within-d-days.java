class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = 0;
        int maxCapacity = 0;
        for(int weight : weights){
            minCapacity = Math.max(weight , minCapacity);
            maxCapacity += weight;
        }

        while(minCapacity < maxCapacity){
            int mid = minCapacity + (maxCapacity - minCapacity)/2;

            if(canShip(weights , mid , days)){
                maxCapacity = mid;
            }
            else{
                minCapacity = mid + 1;
            }
        }
        return minCapacity;
    }
    public boolean canShip(int[] weights , int capacity , int dueDays){
        int currWeight = 0;
        int days = 1;
        for(int weight : weights){
            if(currWeight + weight > capacity){
                days++;
                currWeight = 0;
            }
            currWeight += weight;
        }
        return days <= dueDays;
    }
}