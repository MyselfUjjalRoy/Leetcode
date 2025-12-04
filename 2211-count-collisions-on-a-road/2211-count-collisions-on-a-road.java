class Solution {
    public int countCollisions(String directions) {
        int i = 0;
        int j = directions.length() - 1;
        while(i <= j && directions.charAt(i) == 'L') i++;
        while(i <= j && directions.charAt(j) == 'R') j--;
        
        int collisions = 0;
        while(i <= j){
            if(directions.charAt(i) == 'R' || directions.charAt(i) == 'L') collisions++;
            i++;
        }
        return collisions;
    }
}