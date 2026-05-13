class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> events = new ArrayList<>();

        for(int[] trip : trips){
            int n = trip[0];
            int from = trip[1];
            int to = trip[2];

            events.add(new int[]{from , + n});
            events.add(new int[]{to , -n});
        }

        Collections.sort(events , (a , b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            else{
                return a[0] - b[0];
            }
        });

        int curr = 0;

        for(int[] event : events){
            curr += event[1];

            if(curr > capacity) return false; 
        }

        return true;
    }
}