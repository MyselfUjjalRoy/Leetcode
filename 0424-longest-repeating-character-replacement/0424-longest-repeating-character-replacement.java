class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLen = 0, maxFreq = 0;
        int[] hash = new int[26];
        while(right < s.length()){
            char rightChar = s.charAt(right);
            hash[rightChar - 'A']++;
            maxFreq = Math.max(maxFreq , hash[rightChar - 'A']);
            while((right - left + 1) - maxFreq > k ){
                char leftChar = s.charAt(left);
                hash[leftChar - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen , right - left + 1);
            right++;
        }
        return maxLen;
    }
}