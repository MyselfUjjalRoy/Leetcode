class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb=new StringBuilder(s);

        for(int i=0;i<sb.length();i++)
        {
            char l=sb.charAt(s.length()-1);
            for(int j=s.length()-1;j>0;j--)
            {
                char c=sb.charAt(j-1);
                sb.setCharAt(j,c);
            }
            sb.setCharAt(0,l);
            if(sb.toString().equals(goal))
            {
                return true;
            }
        }
        return false;
    }
}