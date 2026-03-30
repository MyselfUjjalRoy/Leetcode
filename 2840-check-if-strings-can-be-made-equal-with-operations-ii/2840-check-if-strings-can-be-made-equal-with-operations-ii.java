class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] odd1 = new int[26];
        int[] even1 = new int[26];
        int[] odd2 = new int[26];
        int[] even2 = new int[26];

        for(int i = 0; i < s1.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(i % 2 == 0){
                even1[ch1 - 'a']++;
                even2[ch2 - 'a']++;
            }
            else{
                odd1[ch1 - 'a']++;
                odd2[ch2 - 'a']++;
            }
        }

        return Arrays.equals(odd1 , odd2) && Arrays.equals(even1 , even2);
    }
}