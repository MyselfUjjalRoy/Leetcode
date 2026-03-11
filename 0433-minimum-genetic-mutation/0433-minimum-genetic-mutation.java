class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        for(String gene : bank){
            set.add(gene);
        }

        if(!set.contains(endGene)){
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        char[] str = {'A' , 'C' , 'T' , 'G'};

        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String g = queue.poll();
                if(g.equals(endGene)) return steps;

                char[] arr = g.toCharArray();
                for(int j = 0; j < arr.length; j++){
                    char org = arr[j];
                    for(int k = 0; k < str.length; k++){
                        if(str[k] == org) continue;
                        arr[j] = str[k];
                        String newG = new String(arr);
                        if(newG.equals(endGene)) return steps + 1;
                        if(set.contains(newG)){
                            queue.offer(newG);
                            set.remove(newG);
                        }
                    }
                    arr[j] = org;
                }
            }
            steps++;
        }
        return -1;
    }
}