class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        String s1="";
        String s2="";
        String t="";
        for(char ch:firstWord.toCharArray()){
            s1+=ch-'a';
        }
        for(char ch:secondWord.toCharArray()){
            s2+=ch-'a';
        }
        for(char ch:targetWord.toCharArray()){
            t+=ch-'a';
        }
        return Integer.parseInt(s1)+Integer.parseInt(s2)==Integer.parseInt(t);
    }
}