class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int[] evenFreq1 = new int[26];
        int[] evenFreq2 = new int[26];
        int[] oddFreq1 = new int[26];
        int[] oddFreq2 = new int[26];
        
        int n = s1.length();
        for(int i = 0; i < n; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(i % 2 == 0){
                evenFreq1[ch1 - 'a']++;
                evenFreq2[ch2 - 'a']++;
            }
            else{
                oddFreq1[ch1 - 'a']++;
                oddFreq2[ch2 - 'a']++;
            }
        }

        return Arrays.equals(evenFreq1 , evenFreq2) && Arrays.equals(oddFreq1 , oddFreq2);
    }
}