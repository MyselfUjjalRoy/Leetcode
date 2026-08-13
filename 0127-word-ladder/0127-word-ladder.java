class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }

        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                String word = queue.poll();
                char[] str = word.toCharArray();

                for(int j = 0; j < str.length; j++){
                    char original = str[j];

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        str[j] = ch;
                        String newWord = new String(str);

                        if(newWord.equals(endWord)) return steps + 1;
                        else if(set.contains(newWord)){
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