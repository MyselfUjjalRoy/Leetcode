class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for(int hour = 0; hour <= 11; hour++){
            for(int minute = 0; minute <= 59; minute++){
                if(Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn){
                    String hh = String.valueOf(hour);
                    String mm = (minute < 9 ? "0" : "" ) + String.valueOf(minute);
                    ans.add(hh + ":" + mm);
                }
            }
        }
        return ans;
    }
}