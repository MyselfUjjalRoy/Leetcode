class Solution {
    // method 2 - Line sweep algorithm
    // time complexity - O(n)+O(nlogn)+O(n)
    public int maximumPopulation(int[][] logs) {
        List<int[]> events = new ArrayList<>();

        for(int[] log : logs){
            events.add(new int[]{log[0] , +1}); // birth
            events.add(new int[]{log[1] , -1}); // death
        }

        Collections.sort(events , (a , b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1]; // -1 should come first because death will happen first
            }
            else{
                return a[0] - b[0];
            }
        });

        int currPopulation = 0;
        int maxPopulation = 0;
        int ans = 1950;

        for(int[] e : events){
            currPopulation += e[1];

            if(currPopulation > maxPopulation){
                maxPopulation = currPopulation;
                ans = e[0];
            }
        }

        return ans;
    }
}