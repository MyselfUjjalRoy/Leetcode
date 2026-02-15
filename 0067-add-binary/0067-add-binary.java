class Solution {
    public String addBinary(String a, String b) {
        int r1 = a.length() - 1;
        int r2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(r1 >= 0 || r2 >= 0 || carry != 0){
            int val1 = r1 >= 0 ? Character.getNumericValue(a.charAt(r1--)) : 0;
            int val2 = r2 >= 0 ? Character.getNumericValue(b.charAt(r2--))  : 0;
            int sum = val1 + val2 + carry;
            
            sb.append(sum % 2);
            carry = sum / 2;
            
        }
        return sb.reverse().toString();
    }
}