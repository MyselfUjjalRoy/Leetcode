class Solution {
    static final long mod = 1_000_000_007;
    public int countTrapezoids(int[][] points) {
        Map<Integer , Integer> countByY = new HashMap<>();
        for(int[] point : points){
            countByY.put(point[1] , countByY.getOrDefault(point[1] , 0) + 1);
        }

        long totalSegment = 0;
        long ans = 0;
        for(Map.Entry<Integer , Integer> entry : countByY.entrySet()){
            long k = entry.getValue();
            if(k >= 2){
                long currSegment = (k * (k - 1) / 2) % mod;
                ans = (ans + (currSegment % mod) * (totalSegment % mod)) % mod;
                totalSegment = (totalSegment + currSegment) % mod;
            }
        }
        return (int)ans;
    }
}