class Solution {
    Map<String , PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            graph.putIfAbsent(ticket.get(0) , new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        DFS("JFK");

        return result;
    }

    public void DFS(String airport){
        PriorityQueue<String> neighbours = graph.get(airport);

        while(neighbours != null && !neighbours.isEmpty()){
            String  next = neighbours.poll(); // O(log n)
            DFS(next);
        }

        result.addFirst(airport); // reverseOrder
    }
}