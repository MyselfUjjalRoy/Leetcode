class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<s.length();){
            int start=i;
            int end=s.lastIndexOf(s.charAt(start));  
            for(int j=start+1;j<=end-1;j++){
                int lastIndexNextChar=s.lastIndexOf(s.charAt(j));
                if(lastIndexNextChar>end){
                    end=lastIndexNextChar;
                }
            }
            list.add(end-start+1);
            i=end+1;
        }
      return list;
    }
}