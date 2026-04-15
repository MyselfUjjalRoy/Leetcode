class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(words[i].equals(target)){
                int d = Math.abs(i - startIndex);
                int circularD = n - d;

                ans = Math.min(ans , Math.min(d , circularD));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}