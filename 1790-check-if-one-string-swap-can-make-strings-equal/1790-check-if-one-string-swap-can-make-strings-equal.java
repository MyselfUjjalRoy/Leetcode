class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count=0;
        int n=s1.length();
        int[] arr=new int[26];
        for(int i=0;i<n;i++){
            char char1=s1.charAt(i);
            char char2=s2.charAt(i);
            if(char1!=char2){
                count++;
            }
            arr[char1-'a']++;
            arr[char2-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return count==0 || count==2;
    }
}