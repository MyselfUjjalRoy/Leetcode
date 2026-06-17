class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1; 
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < n; i++){
            fact *= i;
            list.add(i);
        }
        list.add(n);

        StringBuilder ans = new StringBuilder();
        k = k - 1;
        while(true){
            ans.append(list.get(k/fact));
            list.remove(k/fact);

            if(list.size() == 0){
                break;
            }

            k = k % fact;
            fact = fact / list.size();
        }
        return ans.toString();
        
    }
}