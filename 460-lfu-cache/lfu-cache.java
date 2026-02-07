class LFUCache {

    class Node {
        int key, val, cnt;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }

    class DLList {
        Node head, tail;
        int size;

        DLList() {
            head = null;
            tail = null;
            size = 0;
        }

        void addToFront(Node node) {
            node.prev = null;
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
            if (tail == null)
                tail = node;
            size++;
        }

        void removeNode(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }

            node.prev = null;
            node.next = null;
            size--;
        }

        Node removeLast() {
            if (size == 0)
                return null;

            Node node = tail;
            removeNode(node);
            return node;
        }
    }

    int capacity, minFreq;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void updateFreq(Node node) {
        int freq = node.cnt;
        DLList list = freqMap.get(freq);
        list.removeNode(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.cnt++;
        freqMap
                .computeIfAbsent(node.cnt, k -> new DLList())
                .addToFront(node);
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key))
            return -1;
        Node node = nodeMap.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            updateFreq(node);
            return;
        }

        if (nodeMap.size() == capacity) {
            DLList minList = freqMap.get(minFreq);
            Node evict = minList.removeLast();
            nodeMap.remove(evict.key);
        }

        Node newNode = new Node(key, value);
        minFreq = 1;
        freqMap.computeIfAbsent(1, k -> new DLList()).addToFront(newNode);
        nodeMap.put(key, newNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */