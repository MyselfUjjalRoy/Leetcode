class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
         Map<Integer, Integer> minX = new HashMap<>();
        Map<Integer, Integer> maxX = new HashMap<>();
        Map<Integer, Integer> minY = new HashMap<>();
        Map<Integer, Integer> maxY = new HashMap<>();

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            minX.put(y, Math.min(minX.getOrDefault(y, n + 1), x));
            maxX.put(y, Math.max(maxX.getOrDefault(y, 0), x));

            minY.put(x, Math.min(minY.getOrDefault(x, n + 1), y));
            maxY.put(x, Math.max(maxY.getOrDefault(x, 0), y));
        }

        int coveredCount = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            if (x > minX.get(y) && x < maxX.get(y) && y > minY.get(x) && y < maxY.get(x)) {
                coveredCount++;
            }
        }

        return coveredCount;
    }
}