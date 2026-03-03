class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int originalColor = image[sr][sc];
        if(originalColor == color) return image;

        dfs(image , sr , sc , originalColor , color , n , m);
        return image;
    }
    public void dfs(int[][] image , int row , int col , int originalColor, int newColor , int n , int m){
        if(row < 0 || col < 0 || row >= n || col >= m || image[row][col] != originalColor){
            return;
        }
        image[row][col] = newColor;
        int[] dx = {-1, 0 , 1 , 0};
        int[] dy = {0 , 1, 0 , -1};

        for(int d = 0; d < 4; d++){
            int nRow = row + dx[d];
            int nCol = col + dy[d];

            dfs(image , nRow , nCol , originalColor , newColor , n , m);
        }
    }
}