class Solution {
    public double angleClock(int hour, int minutes) {
        double angle = Math.abs(30 * hour - 5.5 * minutes);
        if(angle > 180.00) return 360.00000 - angle;
        return angle;
    }
}