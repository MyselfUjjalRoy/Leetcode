class Solution {
    /*  recursion + memoization code gave tle
        so bottom Up approach 
        t[i][j] -> min path sum from triangle[i][j] to bottom
        //Approach-3 : Bottom Up - Just like "Minimum Falling Path Sum"
        //T.C : O(n^2)
        //S.C : O(n)
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] t = new int[n];
        for(int i = 0; i < n; i++){
            t[i] = triangle.get(n - 1).get(i);
        }

        for(int i = n - 2;  i >= 0; i--){
            for(int j = 0; j <= i; j++){
                t[j] = triangle.get(i).get(j) + Math.min(t[j] , t[j + 1]);
            }
        }

        return t[0];
    }
}