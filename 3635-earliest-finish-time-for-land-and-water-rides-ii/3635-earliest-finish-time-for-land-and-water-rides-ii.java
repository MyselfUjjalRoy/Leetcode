public class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minLandFinish = Integer.MAX_VALUE;
        int minWaterFinish = Integer.MAX_VALUE;

        // Minimum finish time for land rides
        for (int i = 0; i < landStartTime.length; i++) {
            int finish = landStartTime[i] + landDuration[i];
            if (finish < minLandFinish) minLandFinish = finish;
        }

        // Minimum finish time for water rides
        for (int j = 0; j < waterStartTime.length; j++) {
            int finish = waterStartTime[j] + waterDuration[j];
            if (finish < minWaterFinish) minWaterFinish = finish;
        }

        // Try both orders: land → water and water → land
        int landThenWater = Integer.MAX_VALUE;
        for (int j = 0; j < waterStartTime.length; j++) {
            int start = Math.max(minLandFinish, waterStartTime[j]);
            landThenWater = Math.min(landThenWater, start + waterDuration[j]);
        }

        int waterThenLand = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            int start = Math.max(minWaterFinish, landStartTime[i]);
            waterThenLand = Math.min(waterThenLand, start + landDuration[i]);
        }

        return Math.min(landThenWater, waterThenLand);
    }
}
