class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n = commands.length;
        Set<String> set = new HashSet<>();
        for(int[] o : obstacles){
            String key = o[0] +"_" + o[1];

            set.add(key);
        }

        int x = 0;
        int y = 0;
        int maxDistance = Integer.MIN_VALUE;

        int[] dir = {0 , 1}; // initially facint north

        for(int i = 0; i < n; i++){
            if(commands[i] == -2){
                dir = new int[]{-dir[1] , dir[0]};
            }
            else if(commands[i] == -1){
                dir = new int[]{dir[1] , -dir[0]};
            }
            else{
                for(int step = 0; step < commands[i]; step++){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    
                    String key = newX + "_" + newY;

                    if(set.contains(key)){
                        break;
                    }
                    
                    x = newX;
                    y = newY;
                }
            }

            maxDistance = Math.max(maxDistance , x * x + y * y);
        }

        return maxDistance;
    }
}