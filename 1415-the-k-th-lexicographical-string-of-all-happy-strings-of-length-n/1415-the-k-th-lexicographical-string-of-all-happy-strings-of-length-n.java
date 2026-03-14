class Solution {
    //Approach - 2
    int count = 0;
    String result = "";
    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder();
        
        solve(n , k , curr);  

        return result;      
    }
    public void solve(int n , int k , StringBuilder curr){
        if(curr.length() == n){
            count++;
            if(count == k){
                result = curr.toString();
            }
            return;
        }

        for(char ch = 'a'; ch <= 'c'; ch++){
            if(curr.length() > 0 && curr.charAt(curr.length() - 1) == ch){
                continue;
            }

            curr.append(ch);

            solve(n , k , curr);

            curr.deleteCharAt(curr.length() - 1);

            if(count >= k) return; // no further recursion
        }
    }
}