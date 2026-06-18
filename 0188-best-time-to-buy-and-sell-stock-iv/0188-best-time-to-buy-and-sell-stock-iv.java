class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] prev = new int[3][k + 1];

        for(int i = 0; i < n + 1; i++){
            for(int option = 0; option <= 2; option++){
                prev[option][0] = 0;
            }
        }

        for(int option = 0; option <= 2; option++){
            for(int capacity = 0; capacity < k + 1; capacity++){
                prev[option][capacity] = 0;
            }
        }

        for(int idx = n - 1; idx >= 0; idx--){
            int[][] curr = new int[3][k + 1];
            for(int option = 0; option <= 1; option++){
                for(int capacity = 1; capacity <= k; capacity++){
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

        return prev[1][k];
    }
}