class Solution {
    // Time Complexity: O(n log n)
    // Reason:
    // - For n segments, we do 2 TreeMap insert/update operations.
    // - Each TreeMap operation takes O(log n).
    // - Traversing all unique points takes O(n).
    // Total = O(n log n) + O(n) = O(n log n)
    public List<List<Long>> splitPainting(int[][] segments) {
       TreeMap<Integer , Long> events = new TreeMap<>();

       for(int[] segment : segments){
            int start = segment[0];
            int end = segment[1];
            int color = segment[2];

            events.put(start , events.getOrDefault(start , 0L) + color);
            events.put(end , events.getOrDefault(end , 0L) - color);
       } 

       long sum = 0;
       Integer prev = null;

       List<List<Long>> ans = new ArrayList<>();

       for(Map.Entry<Integer , Long> entry : events.entrySet()){
            int point = entry.getKey();

            if(prev != null && sum > 0){
                ans.add(List.of((long) prev , (long)point , (long) sum));
            }

            sum += entry.getValue();
            prev = point;
       }

       return ans;
    }
}