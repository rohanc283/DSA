import java.util.*;

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    Node recent;
    Node least;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.recent = null;
        this.least = null;
    }

    private void moveToRecent(Node node) {
        if (node == recent)
            return;

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            least = node.prev;
        }

        node.prev = null;
        node.next = recent;
        if (recent != null) {
            recent.prev = node;
        }
        recent = node;

        if (least == null) {
            least = recent;
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToRecent(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToRecent(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);

            node.next = recent;
            node.prev = null;
            if (recent != null) {
                recent.prev = node;
            }
            recent = node;

            if (least == null) {
                least = node;
            }
        }

        if (map.size() > capacity) {
            map.remove(least.key);
            if (least.prev != null) {
                least = least.prev;
                least.next = null;
            } else {
                recent = null;
                least = null;
            }
        }
    }
}