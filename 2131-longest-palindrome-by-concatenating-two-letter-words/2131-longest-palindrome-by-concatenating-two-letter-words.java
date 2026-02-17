class Solution {
    public int longestPalindrome(String[] words) {
        int len = 0;
        Map<String , Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word , map.getOrDefault(word , 0) + 1);
        }

        boolean centerUsed = false;

        for(String word : words){
            String rev = new StringBuilder(word).reverse().toString();

            if(!word.equals(rev)){ //ab  ba
                if(map.get(word) > 0 && map.getOrDefault(rev , 0) > 0){
                    len += 4;
                    map.put(word , map.get(word) - 1);
                    map.put(rev , map.get(rev) - 1);
                }
            }
            else{ // ab cc cc ba  -> means rev == word
                if(map.get(word) >= 2){
                    map.put(word , map.get(word) - 2);
                    len += 4;
                }
                else if(map.get(word) == 1 && centerUsed == false){// can used for middle ab cc dd cc ba
                    map.put(word , map.get(word) - 1);
                    len += 2;
                    centerUsed = true;
                }
            }
        }
        return len;
    }
}