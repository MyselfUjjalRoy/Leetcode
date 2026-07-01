class Solution {
    /*
        Time Complexity: O(n² log 400) ≈ O(n²)
        Space Complexity: O(n²)
    */
   int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] distNearestThief = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int curr_i = curr[0];
                int curr_j = curr[1];

                distNearestThief[curr_i][curr_j] = level;

                for (int[] dir : directions) {
                    int new_i = curr_i + dir[0];
                    int new_j = curr_j + dir[1];

                    if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j]) {
                        continue;
                    }

                    queue.offer(new int[] { new_i, new_j });
                    visited[new_i][new_j] = true;
                }
            }
            level++;
        }

        int low = 0;
        int high = 400;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isSafe(distNearestThief, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean isSafe(int[][] distNearestThief, int safeFactor) {
        int n = distNearestThief.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[] { 0, 0 });

        if (distNearestThief[0][0] < safeFactor)
            return false;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curr_i = curr[0];
            int curr_j = curr[1];

            if (curr_i == n - 1 && curr_j == n - 1)
                return true;

            for (int[] dir : directions) {
                int new_i = curr_i + dir[0];
                int new_j = curr_j + dir[1];

                if (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n && !visited[new_i][new_j]) {
                    if (distNearestThief[new_i][new_j] < safeFactor) {
                        continue;
                    }
                    queue.offer(new int[] { new_i, new_j });
                    visited[new_i][new_j] = true;
                }

            }
        }
        return false;
    }
}