class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] t = new boolean[n + 1][n + 1];
        /*
        t[i][j] = true : s[i:j] is a substring where i and j are inclusive indices
        */
        int count = 0;

        for(int length = 1; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;

                if(i == j){// means 1 length string
                    t[i][j] = true;
                }
                else if(i + 1 == j){// means 2 length string
                    t[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{// length > 2 strings
                    t[i][j] = (s.charAt(i) == s.charAt(j) && t[i+1][j - 1]);
                }

                if(t[i][j] == true){// means from i to j , I found a valid palindrome string
                    count++;
                }
            }
        }

        return count;
    }
}