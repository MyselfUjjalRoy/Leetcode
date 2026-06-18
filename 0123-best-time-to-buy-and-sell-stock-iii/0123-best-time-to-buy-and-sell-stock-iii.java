class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][3];

        for(int i = 0; i < n + 1; i++){ // base case 2 -> capacity == 0
            for(int option = 0; option <= 1; option++){
                prev[option][0] = 0;
            }
        }

        for(int option = 0; option <= 1; option++){ // base case 1 -> idx == n
            for(int capacity = 0; capacity <= 2; capacity++){
                prev[option][capacity] = 0;
            }
        }

        for(int idx = n - 1; idx >= 0; idx--){

            int[][] curr = new int[2][3];

             for(int option = 0; option <= 1; option++){
                for(int capacity = 1; capacity <= 2; capacity++){
                    int profit = 0;

                    if(option == 1){
                        profit = Math.max(-prices[idx] + prev[0][capacity] , 0 + prev[1][capacity]);
                    }
                    else{
                        profit = Math.max(prices[idx] + prev[1][capacity - 1] , 0 + prev[0][capacity]);
                    }

                    curr[option][capacity] = profit;
                }
            }

            prev = curr;
        }

        return prev[1][2];
    }
}