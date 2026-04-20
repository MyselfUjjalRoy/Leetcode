class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ans = Integer.MIN_VALUE;

        //fix the right point
        for(int i = 0; i < n; i++){
            if(colors[i] != colors[n - 1]){
                ans = Math.max(ans , Math.abs(i - (n - 1)));
                break;
            }
        }

        // fix the left point
        for(int i = n - 1; i >= 0; i--){
            if(colors[i] != colors[0]){
                ans = Math.max(ans , Math.abs(i - 0));
            }
        }

        return ans;
    }
}