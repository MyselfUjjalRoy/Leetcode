//Approach (Iterate and check)
//T.C : O(q * d * n), q = queries.size(), d = dictionary.size(), n = query[i].length()
//S.C : O(1)
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for(String q : queries){
            for(String s : dictionary){
                int diff = 0;
                for(int i = 0; i < q.length(); i++){
                    if(q.charAt(i) != s.charAt(i)){
                        diff++;
                    }
                    
                    if(diff > 2){
                        break;
                    }
                }

                if(diff <= 2){
                    ans.add(q);
                    break;
                }
            }
        }

        return ans;
    }
}