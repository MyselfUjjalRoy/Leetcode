class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIdx = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            lastIdx[idx] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] used = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if(used[idx] == false){
                while(stack.size() > 0 && stack.peek() > ch && lastIdx[stack.peek() - 'a'] > i){
                    used[stack.peek() - 'a'] = false;
                    stack.pop();
                }
                stack.push(ch);
                used[idx] = true;
            }
        }

        StringBuilder seq = new StringBuilder();
        while(stack.size() > 0){
            seq.append(stack.pop());
        }

        return seq.reverse().toString();
    }
}