class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;

        Map<Integer , List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i] , k -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int index = queue.poll();

                if(index == n - 1) return steps;

                if(index + 1 < n && !visited[index + 1]){
                    queue.offer(index + 1);
                    visited[index + 1] = true;
                }

                if(index - 1 >= 0 && !visited[index - 1]){
                    queue.offer(index - 1);
                    visited[index - 1] = true;
                }

                if(map.containsKey(arr[index])){
                    for(int idx : map.get(arr[index])){
                        if(!visited[idx]){
                            visited[idx] = true;
                            queue.offer(idx);
                        }
                    }
                    map.remove(arr[index]);
                }
            }

            steps++;
        }

        return steps;
    }
}