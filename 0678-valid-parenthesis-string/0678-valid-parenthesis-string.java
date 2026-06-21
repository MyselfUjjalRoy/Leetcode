class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> aestericks = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                openBrackets.push(i);
            }
            else if(ch == '*'){
                aestericks.push(i);
            }
            else{
                if(!openBrackets.isEmpty()){
                    openBrackets.pop();
                }
                else if(!aestericks.isEmpty()){
                    aestericks.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!openBrackets.isEmpty()){
            if(aestericks.isEmpty()){
                return false;
            }
            if(openBrackets.pop() > aestericks.pop()){
                return false;
            }
        }

        return openBrackets.isEmpty();
    }
}