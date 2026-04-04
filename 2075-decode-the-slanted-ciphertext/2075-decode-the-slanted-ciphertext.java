//Approach-1 (Simple simulation with extra space)
//T.C : O(l), l = encodedText.length()
//S.C : O(l), all characters of encodedText in matrix
// T.C : O(l)
// S.C : O(l)
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1){
            return encodedText;
        }
        int n = encodedText.length();
        int cols = n / rows;
        char[][] mat = new char[rows][cols];
        
        int idx = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                mat[i][j] = encodedText.charAt(idx);
                idx++;
            }
        }

        StringBuilder originalText = new StringBuilder();

        // read the matrix diagonally to get the original text
        for(int col = 0; col < cols; col++){
            int i = 0 , j = col;
            while(i <  rows && j < cols){
                originalText.append(mat[i][j]);
                i++;
                j++;
            }
        }

        return originalText.toString().stripTrailing();
    }
}