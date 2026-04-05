class Solution {
    Map<String , Integer> memo = new HashMap<>();

    public int maxLength(List<String> arr) {
        return solve(0 , arr , "" , arr.size());
    }

    public int solve(int idx , List<String> arr , String temp , int n){
        if(idx >= n){
            return temp.length();
        }

        String key = temp + idx;

        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int include = 0;
        int exclude = 0;

        if(hasCommon(arr.get(idx) , temp)){
            exclude = solve(idx + 1 , arr , temp , n);
        }
        else{
            exclude = solve(idx + 1 , arr , temp , n);
            include = solve(idx + 1 , arr , temp + arr.get(idx) , n);
        }

        int result = Math.max(include , exclude);
        memo.put(key , result);

        return result;
    }

    public boolean hasCommon(String s1 , String s2){
        int[] arr = new int[26];

        for(char ch : s1.toCharArray()){
            if(arr[ch - 'a'] > 0){ // suppose {aa , bb}
                return true;
            }
            arr[ch - 'a']++;
        }

        for(char ch : s2.toCharArray()){
            if(arr[ch - 'a'] > 0){ // to checkk duplicate
                return true;
            }
        }

        return false;
    }
}