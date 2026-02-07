class Node {
    int count;
    Set<String> keys;
    Node next = null;
    Node prev = null;

    Node(int cnt) {
        this.count = cnt;
        this.keys = new HashSet<>();
    }
}

class AllOne {

    Map<String, Node> map = new HashMap<>();
    Node root, last;

    public AllOne() {
        root = new Node(0);
        last = root;
    }

    private void addNode(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
        prevNode.next = newNode;
        if (prevNode == last) {
            last = newNode;
        }
    }

    private void removeNode(Node currNode) {
        currNode.prev.next = currNode.next;
        if (currNode.next != null) {
            currNode.next.prev = currNode.prev;
        }
        if (currNode == last) {
            last = currNode.prev;
        }
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (root.next == null || root.next.count != 1) {
                addNode(root, 1);
            }
            root.next.keys.add(key);
            map.put(key, root.next);
        } else {
            Node currNode = map.get(key);
            int currCount = currNode.count;
            if (currNode.next == null || currNode.next.count != currCount + 1) {
                addNode(currNode, currCount + 1);
            }
            currNode.next.keys.add(key);
            map.put(key, currNode.next);
            currNode.keys.remove(key);
            if (currNode.keys.size() == 0) {
                removeNode(currNode);
            }
        }
    }

    public void dec(String key) {
        Node currNode = map.get(key);
        int currCount = currNode.count;
        if (currCount == 1) {
            map.remove(key);
        } else {
            if (currNode.prev.count != currCount - 1) {
                addNode(currNode.prev, currCount - 1);
            }
            currNode.prev.keys.add(key);
            map.put(key, currNode.prev);
        }
        currNode.keys.remove(key);
        if (currNode.keys.size() == 0) {
            removeNode(currNode);
        }
    }

    public String getMaxKey() {
        if (last == root)
            return "";
        String maxKey = last.keys.iterator().next();
        return maxKey;
    }

    public String getMinKey() {
        if (root.next == null) {
            return "";
        }
        String minKey = root.next.keys.iterator().next();
        return minKey;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */