class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)) set.add(ch);
        }

        int count = 0;
        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch) && set.contains(Character.toUpperCase(ch))){
                count++;
                set.remove(Character.toUpperCase(ch));
            }
        }

        return count;
    }
}