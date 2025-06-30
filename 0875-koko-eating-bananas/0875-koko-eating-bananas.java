class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = Integer.MIN_VALUE;
        for(int pile : piles){
            maxSpeed = Math.max(maxSpeed , pile);
        }
        while(minSpeed <= maxSpeed){
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;
            if(canEatAll(piles, mid , h)){
                maxSpeed = mid-1;
            }
            else{
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }
    public boolean canEatAll(int[] piles , int speed , int h){
        int hours = 0;
        for(int pile : piles){
            hours += Math.ceil((pile * 1.0) / speed);
        }
        return hours <= h;
    }
}