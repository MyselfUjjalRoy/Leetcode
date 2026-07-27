class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        Map<Character , Integer> need = new HashMap<>();

        for(char ch : t.toCharArray()){
            need.put(ch , need.getOrDefault(ch , 0) + 1);
        }
        
        int required = need.size();

        int left = 0;
        int start = 0;
        int have = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character , Integer> window = new HashMap<>();

        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            window.put(ch , window.getOrDefault(ch , 0) + 1);

            if(need.containsKey(ch) && window.get(ch).equals(need.get(ch))){ // not == 
                have++;
            }

            while(have == required){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar , window.getOrDefault(leftChar , 0) - 1);

                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start , start + minLen);
    }
}