class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            char digit = num.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peek() - '0' > digit - '0'){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while(k-- > 0) stack.pop();

        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }

        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}