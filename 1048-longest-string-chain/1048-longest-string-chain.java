class Solution {
    public int longestStrChain(String words[]) {
        // code here
        int n = words.length;
        Arrays.sort(words , (s1 , s2) -> s1.length() - s2.length()); 
        
        int[] t = new int[n];
        Arrays.fill(t , 1);
        
        int maxLis = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(isPredecessor(words[j] , words[i])){
                    t[i] = Math.max(t[i] , 1 + t[j]);
                    maxLis = Math.max(maxLis , t[i]);
                }
            }
        }
        
        return maxLis;
    }
    
    public boolean isPredecessor(String prev , String curr){
        if((curr.length() - prev.length()) != 1){
            return false;
        }
        
        int i = 0 , j = 0;
        
        while(i < prev.length() && j < curr.length()){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            
            j++;
        }
        
        return i == prev.length();
    }
}



