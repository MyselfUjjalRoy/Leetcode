class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int start = 0;

        int maxLen = 0;

        for(int end = 0; end < n; end++){
            char ch = s.charAt(end);
            while(set.contains(ch)){
                set.remove(s.charAt(start++));
            }

            set.add(ch);
            
            maxLen = Math.max(maxLen , end - start + 1);
        }

        return maxLen;
    }
}