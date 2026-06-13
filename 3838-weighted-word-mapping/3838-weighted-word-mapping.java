class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String w : words){
            int sum = 0;
            for(char ch : w.toCharArray()) sum += weights[ch - 'a'];
            sb.append((char)('z' - sum % 26));
        }
        return sb.toString();
    }
}