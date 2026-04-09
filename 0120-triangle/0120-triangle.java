class Solution {
    /*  recursion + memoization code gave tle
        so bottom Up approach 
        t[i][j] -> min path sum from triangle[i][j] to bottom

    */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                arr[i][j] = triangle.get(i).get(j);
            }
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                arr[i][j] = arr[i][j] + Math.min(arr[i + 1][j] , arr[i + 1][j + 1]);
            }
        }

        return arr[0][0];
    }
}