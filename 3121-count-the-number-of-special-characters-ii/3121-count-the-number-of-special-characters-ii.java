class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                map.put(ch, i);
            } else {
                if (!map.containsKey(ch)) {
                    map.put(ch, i);
                }
            }
        }

        int special = 0;

        for (char ch : map.keySet()) {
            if (Character.isLowerCase(ch)) {
                char upper = Character.toUpperCase(ch);
                if (map.containsKey(upper) && map.get(upper) > map.get(ch)) {
                    special++;
                }
            }
        }

        return special;
    }
}