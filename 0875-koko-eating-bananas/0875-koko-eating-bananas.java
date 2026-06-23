class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for(int pile : piles){
            maxSpeed = Math.max(maxSpeed , pile);
        }

        int ans = maxSpeed;

        while(minSpeed <= maxSpeed){
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            if(canEat(mid , h , piles)){
                ans = mid;
                maxSpeed = mid - 1;
            }
            else{
                minSpeed = mid + 1;
            }
        }

        return ans;
    }

    public boolean canEat(int speed , int limit , int[] piles){
        long time = 0;

        for(int pile : piles){
            time = time + (pile + speed - 1) / speed;
        }

        return time <= limit;
    }
}