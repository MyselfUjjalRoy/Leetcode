class Solution {
    int m , n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;

        int orgColor = image[sr][sc];
        if(orgColor == newColor) return image;

        dfs(image , sr , sc , newColor , orgColor);

        return image;
    }

    public void dfs(int[][] image , int r , int c , int newColor , int orgColor){
        if(r < 0 || c < 0 || r >= m || c >= n || image[r][c] != orgColor){
            return;
        }

        image[r][c] = newColor;

        int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};

        for(int d = 0; d < 4; d++){
            int nR = r + dir[2 * d];
            int nC = c + dir[2 * d + 1];

            dfs(image , nR , nC , newColor , orgColor);
        }
    }
}