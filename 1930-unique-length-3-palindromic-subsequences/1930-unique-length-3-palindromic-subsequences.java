class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Map<Character , int[]> firstAndLast = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!firstAndLast.containsKey(ch)){
                firstAndLast.put(ch , new int[]{i , i});
            }
            else{
                firstAndLast.get(ch)[1] = i;
            }
        }
        int count = 0;
        for(char ch : firstAndLast.keySet()){
            int[] range = firstAndLast.get(ch);
            int left = range[0];
            int right = range[1];
            Set<Character> set = new HashSet<>();
            for(int i = left + 1; i < right; i++){
                set.add(s.charAt(i));
            }
            count += set.size();
        }
        return count;
    }
}