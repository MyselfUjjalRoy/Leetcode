class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int N = n + m - 1;

        char[] word = new char[N];
        boolean[] canChange = new boolean[N];

        // fill with placeholders
        for(int i = 0; i < N; i++){
            word[i] = '$';
        }

        // process the 'T' 
        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == 'T'){
                int idx = i;
                for(int j = 0; j < m; j++){
                    if(word[idx] != '$' && word[idx] != str2.charAt(j)){ // if a character is already present at idx and that it not equal to str2[j] -> return ""
                        return "";
                    }

                    word[idx] = str2.charAt(j);
                    idx++;
                }
            }
        }

        // now fill the remaining places with smallest character 'a'
        for(int i = 0; i < N; i++){
            if(word[i] == '$'){
                word[i] = 'a';
                canChange[i] = true;
            }
        }


        for(int i = 0; i < n; i++){  
            if(str1.charAt(i) == 'F'){
                if(isSame(word , str2 , i , m)){
                    boolean isChanged = false;
                    for(int k = i + m - 1; k >= i; k--){
                        if(canChange[k] == true){
                            word[k] = 'b';
                            canChange[k] = false;
                            isChanged = true;
                            break;
                        }
                    }
                    if(!isChanged) return "";
                }
            }
        }
        return new String(word);
    }

    public boolean isSame(char[] word , String str2 , int i , int m){
        for(int j = 0; j < m; j++){
            if(word[i] != str2.charAt(j)){
                return false;
            }
            i++;
        }

        return true;
    }
}