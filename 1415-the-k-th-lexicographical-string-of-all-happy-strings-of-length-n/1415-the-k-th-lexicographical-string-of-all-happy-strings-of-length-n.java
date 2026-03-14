class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        solve(n , curr , list);

        if(list.size() < k) return "";

        return list.get(k - 1);
    }
    public void solve(int n , StringBuilder curr , ArrayList<String> list){
        if(curr.length() == n){
            list.add(curr.toString());
            return;
        }

        for(char ch = 'a'; ch <= 'c'; ch++){
            if(curr.length() > 0 && curr.charAt(curr.length() - 1) == ch){
                continue;
            }

            curr.append(ch);

            solve(n, curr , list);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}