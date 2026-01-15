class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxConsecutive_HBars = 1;
        int maxConsecutive_VBars = 1;

        int currConsecutive_HBars = 1;
        for(int i = 1; i < hBars.length; i++){
            if(hBars[i] - hBars[i-1] == 1){
                currConsecutive_HBars++;
            }
            else{
                currConsecutive_HBars = 1;
            }
            maxConsecutive_HBars = Math.max(maxConsecutive_HBars , currConsecutive_HBars);
        }

        int currConsecutive_VBars = 1;
        for(int i = 1; i < vBars.length; i++){
            if(vBars[i] - vBars[i-1] == 1){
                currConsecutive_VBars++;
            }
            else{
                currConsecutive_VBars = 1;
            }
            maxConsecutive_VBars = Math.max(maxConsecutive_VBars , currConsecutive_VBars);
        }
        int side = Math.min(maxConsecutive_HBars , maxConsecutive_VBars) + 1;
        return side * side;
    }
}