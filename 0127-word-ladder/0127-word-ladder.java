class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }

        if(!set.contains(endWord)) return 0;

        int steps = 1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                String word = queue.poll();
                if(word.equals(endWord)) return steps;

                char[] str = word.toCharArray();

                for(int j = 0; j < str.length; j++){
                    char original = str[j];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(ch == original) continue;
                        str[j] = ch;
                        String newWord = new String(str);
                        if(newWord.equals(endWord)) return steps + 1;
                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    str[j] = original;
                }
            }
            steps++;
        }
        return 0;
    }
}