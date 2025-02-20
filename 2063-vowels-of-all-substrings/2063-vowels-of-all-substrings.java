class Solution {
    public boolean isVowel(char ch){
        return (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u');
    }
    public long countVowels(String word) {
        long count=0;
        int n=word.length();
        for(int i=0;i<n;i++){
            if(isVowel(word.charAt(i))){
                count+=(long)(i+1)*(n-i);
            }
        }
        return count;
    }
}