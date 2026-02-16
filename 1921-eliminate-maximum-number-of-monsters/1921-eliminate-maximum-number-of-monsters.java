class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int time[] = new int[n];

        for(int i = 0; i < n; i++){
            time[i] = (int)Math.ceil((double)dist[i]/speed[i]);
        }
        Arrays.sort(time);
        int time_passed = 1;
        int count = 1;
        for(int i = 1; i < n; i++){
            if(time[i] - time_passed <= 0){
                return count;
            }
            count += 1;
            time_passed += 1;
        }
        return count;
    }
}