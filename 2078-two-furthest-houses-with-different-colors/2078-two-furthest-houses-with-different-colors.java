class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(colors[i] != colors[j]){
                    ans = Math.max(ans , Math.abs(i - j));
                }
            }
        }

        return ans;
       

        //return ans;
    }
}