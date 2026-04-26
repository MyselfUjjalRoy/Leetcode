class Solution {
    public static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public String sortVowels(String s) {
        int n = s.length();
        Map<Character , Integer> freq = new HashMap<>();
        Map<Character , Integer> firstIndex = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(isVowel(s.charAt(i))){
                freq.put(s.charAt(i) , freq.getOrDefault(s.charAt(i) , 0) + 1);

                firstIndex.putIfAbsent(s.charAt(i) , i);
            }
        }

        List<Character> vowels = new ArrayList<>(freq.keySet());
        Collections.sort(vowels , (a , b)->{
            if(!freq.get(a).equals(freq.get(b))){
                return freq.get(b) - freq.get(a);
            }
            else{
                return firstIndex.get(a) - firstIndex.get(b);
            }
        });

        List<Character> expanded = new ArrayList<>();

        for(char v : vowels){
            int count = freq.get(v);
            while(count-- > 0){
                expanded.add(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(!isVowel(ch)){
                sb.append(ch);
            }
            else{
                sb.append(expanded.get(idx++));
            }
        }

        return sb.toString();
    }
}