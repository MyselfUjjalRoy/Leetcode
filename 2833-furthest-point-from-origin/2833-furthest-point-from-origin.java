class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int Distance = 0;
        int points = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'L'){
                Distance--;
            }
            else if(moves.charAt(i) == 'R'){
                Distance++;
            }
            else{
                points++;
            }
        }

        return Math.max(Distance + points , Math.abs(Distance - points));
    }
}