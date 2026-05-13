class MyCalendarTwo {
    private TreeMap<Integer , Integer> treeMap;
    public MyCalendarTwo() {
        treeMap = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        treeMap.put(startTime , treeMap.getOrDefault(startTime , 0) + 1);
        treeMap.put(endTime , treeMap.getOrDefault(endTime , 0) - 1);

        int count = 0;

        for(int c : treeMap.values()){
            count += c;

            if(count > 2){
                treeMap.put(startTime , treeMap.get(startTime) -1); // reverting events
                if(treeMap.get(startTime) == 0){
                    treeMap.remove(startTime);
                }

                treeMap.put(endTime , treeMap.get(endTime) + 1); // as reverting
                if(treeMap.get(endTime) == 0){
                    treeMap.remove(endTime);
                }

                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */