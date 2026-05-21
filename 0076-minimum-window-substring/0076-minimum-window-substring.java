class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        Map<Character , Integer> need = new HashMap<>();

        for(char ch : t.toCharArray()){
            need.put(ch , need.getOrDefault(ch , 0) + 1);
        }

        Map<Character , Integer> window = new HashMap<>();
        int have = 0;
        int left = 0;

        int start = 0; // to get the string
        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            window.put(ch , window.getOrDefault(ch , 0) + 1);

            if(need.containsKey(ch) && need.get(ch).equals(window.get(ch))){
                have++;
            }

            while(have == need.size()){
                if(right - left + 1 < minLen){
                    minLen = Math.min(minLen , right - left + 1);
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar , window.get(leftChar) - 1);
                
                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start , start + minLen);
    }
}