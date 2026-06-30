class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] count = new int[3];
        int ans = 0;
        int left = 0;

        for(int i = 0; i < n; i++){
            count[s.charAt(i) - 'a']++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                ans += n - i;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;     
    }
}