class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> aesterick = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                openBrackets.push(i);
            }
            else if(ch == '*'){
                aesterick.push(i);
            }
            else{
                if(!openBrackets.isEmpty()){
                    openBrackets.pop();
                }
                else if(!aesterick.isEmpty()){
                    aesterick.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!openBrackets.isEmpty()){
            if(aesterick.isEmpty()){
                return false;
            }
            else if(openBrackets.pop() > aesterick.pop()){
                return false;
            }
        }

        return true;
    }
}