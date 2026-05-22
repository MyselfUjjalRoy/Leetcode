class Solution {
    public boolean isValid(String s) {
        int prevLength = -1;

        while(prevLength != s.length()){
            prevLength = s.length();
            s = s.replace("()" , "").replace("{}" , "").replace("[]" , "");
        }

        return s.isEmpty();
    }
}