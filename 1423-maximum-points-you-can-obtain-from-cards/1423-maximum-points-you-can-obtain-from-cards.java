class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalPoints = 0;
        for(int point : cardPoints){
            totalPoints += point;
        }

        if(k == n)return totalPoints;

        int windowSize = n -k;

        int windowPoints = 0;
        for(int i = 0; i < windowSize; i++){
            windowPoints += cardPoints[i];
        }

        int minWindowPoints = windowPoints;

        for(int j = windowSize; j < n; j++){
            windowPoints += cardPoints[j];
            windowPoints -= cardPoints[j - windowSize];

            minWindowPoints = Math.min(windowPoints , minWindowPoints);
        }

        return totalPoints - minWindowPoints;
    }
}