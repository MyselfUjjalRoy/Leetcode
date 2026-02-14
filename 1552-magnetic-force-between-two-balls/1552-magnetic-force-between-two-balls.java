class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int minForce = 1;
        int maxForce = position[n - 1] - position[0];

        int ans = 0;

        while(minForce <= maxForce){
            int midForce = minForce + (maxForce - minForce) / 2;
            if(isPossible(midForce , position , m)){
                ans = midForce;
                minForce = midForce + 1;
            }
            else{
                maxForce = midForce - 1;
            }
        }
        return ans;
    }
    public boolean isPossible(int force , int[] position , int m){
        int prev = position[0];
        int count = 1;
        int n = position.length;
        for(int i = 1; i < n; i++){
            if(position[i] - prev >= force){
                count++;
                prev = position[i];
            }
            if(count == m) break;
        }
        return count == m;
    }
}