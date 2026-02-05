class LFUCache {
    class Node {
        int key, value, freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private int capacity;
    private int size;
    private int minFreq;

    private Map<Integer, Node> keyNode;
    private Map<Integer, LinkedHashSet<Node>> freqMap; // freq -> nodes

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.keyNode = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) {
            return -1;
        }
        Node node = keyNode.get(key);
        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            increaseFrequency(node);
        } else {
            if (size == capacity) {
                LinkedHashSet<Node> nodes = freqMap.get(minFreq);
                Node toRemove = nodes.iterator().next();//LRU node
                nodes.remove(toRemove);
                if (nodes.isEmpty())
                    freqMap.remove(minFreq);
                keyNode.remove(toRemove.key);
                size--;
            }
            //add new Node
            Node newNode = new Node(key, value);
            keyNode.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
            minFreq = 1;//as new node is just being added
            size++;
        }
    }

    private void increaseFrequency(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> nodes = freqMap.get(freq);
        nodes.remove(node);
        if (nodes.isEmpty()) {
            freqMap.remove(freq);
            if (freq == minFreq)
                minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */