class MyCalendarThree {
    private TreeMap<Integer , Integer> treeMap;
    public MyCalendarThree() {
        treeMap = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        treeMap.put(startTime , treeMap.getOrDefault(startTime , 0) + 1);
        treeMap.put(endTime , treeMap.getOrDefault(endTime , 0) - 1);

        int count = 0;
        int ans = 0;

        for(int c : treeMap.values()){
            count += c;
            ans = Math.max(ans , count);

           // System.out.println(ans);            
        }

        return ans;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */