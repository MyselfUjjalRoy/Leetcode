class Solution {
    public int reverseDegree(String s) {
        int score = 0;
        for(int i = 0; i < s.length(); i++){
            int val = 26 - (s.charAt(i) - 'a');
            System.out.println(val);
            score += val * (i + 1);
        }

        return score;
    }
}