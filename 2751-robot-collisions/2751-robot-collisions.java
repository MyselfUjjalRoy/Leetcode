class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for(int i = 0; i < n; i++){
            indices[i] = i;
        }

        Arrays.sort(indices , (a , b)-> Integer.compare(positions[a] , positions[b]));

        Stack<Integer> stack = new Stack<>();
        
        for(int currIdx : indices){
            if(directions.charAt(currIdx) == 'R'){
                stack.push(currIdx);
            }
            else{
                while(!stack.isEmpty() && healths[currIdx] > 0){
                    int topIdx = stack.pop();

                    if(healths[topIdx] < healths[currIdx]){
                        healths[currIdx] -= 1;
                        healths[topIdx] = 0;
                    }
                    else if(healths[topIdx] > healths[currIdx]){
                        healths[topIdx] -= 1;
                        healths[currIdx] = 0;
                        stack.push(topIdx);
                    }
                    else{
                        healths[topIdx] = 0;
                        healths[currIdx] = 0;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int health : healths){
            if(health > 0){
                ans.add(health);
            }
        }

        return ans;
        
    }
}