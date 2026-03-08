class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] sChars = s.toCharArray();
        char[] sortedChars = s.toCharArray();
        Arrays.sort(sortedChars);

        if(Arrays.equals(sChars , sortedChars)) return 0;

        char minVal = sortedChars[0];
        char maxVal = sortedChars[n - 1];
        if(minVal == sChars[0] || maxVal == sChars[n - 1]) return 1;

        boolean minAtEnd = true;
        boolean maxAtStart = true;
        for(int i = 0; i < n - 1; i++){
            if(minVal == sChars[i]){
                minAtEnd = false;
                break;
            }
        }
        for(int i = 1; i < n; i++){
            if(maxVal == sChars[i]){
                maxAtStart = false;
                break;
            }
        }
        if(minAtEnd && maxAtStart){
            if(n == 2){
                return -1;
            }
            else{
                return 3;
            }
        }
        return 2;
    }
}