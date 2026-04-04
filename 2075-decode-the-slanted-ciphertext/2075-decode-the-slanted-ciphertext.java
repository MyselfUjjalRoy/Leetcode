//Approach-2 (Without extra space)
//T.C : O(l), l = encodedText.length()
//S.C : O(1)
// T.C : O(l)
// S.C : O(1)

// corner case :- _b_ _ ac , so in the string there can be space at the beginning of the string also so , don't just trim the whole string or , if you see a space then don't go forward , stop iterating the string , this will also be wrong , so be careful , otherwise it is good to go............
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder originalText = new StringBuilder();

        for(int col = 0; col < cols; col++){
            for(int j = col; j < n; j += (cols + 1)){
                originalText.append(encodedText.charAt(j));
            }
        }

        return originalText.toString().stripTrailing();
    }
}