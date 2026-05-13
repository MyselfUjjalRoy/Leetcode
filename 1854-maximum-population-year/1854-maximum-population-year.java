class Solution {
    // method 1 - using difference array technique
    // time complexity - O(n + 101)
    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[2051];

        for(int[] log : logs){
            int birth = log[0];
            int death = log[1];

            diff[birth] += 1;
            diff[death] -= 1;
        }

        int maxPopulation = 0;
        int currPopulation = 0;
        int ans = 1950;

        for(int year = 1950; year <= 2050; year++){
            currPopulation += diff[year];

            if(currPopulation > maxPopulation){
                maxPopulation = currPopulation;
                ans = year;
            }
        }

        return ans;
    }
}