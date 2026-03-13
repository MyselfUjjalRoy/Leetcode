class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxTime = 0;
        for(int t : workerTimes){
            maxTime = Math.max(maxTime , t);
        }

        long l = 1;
        long r = (long)maxTime * mountainHeight * (mountainHeight + 1) / 2;

        long ans = 0;

        while(l <= r){
            long mid = l + (r - l)/2;

            if(isPossible(mid, workerTimes , mountainHeight)){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public boolean isPossible(long mid , int[] workerTimes , int mountainHeight){
        long h = 0;
        for(int t : workerTimes){
            h += (long)(Math.sqrt(2 * mid/ t + 0.25) - 0.5);

            if(h >= mountainHeight){
                return true;
            }
        }
        return h >= mountainHeight;
    }
}