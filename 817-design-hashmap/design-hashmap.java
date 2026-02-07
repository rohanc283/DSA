class MyHashMap {
    static class Entry {
        int key, value;

        Entry(int k, int v) {
            key = k;
            value = v;
        }
    }

    private List<List<Entry>> buckets;
    private static final int N = 15000;

    public MyHashMap() {
        buckets = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int getIdx(int key) {
        return (key & 0x7fffffff) % N;
    }

    public void put(int key, int value) {
        int idx = getIdx(key);
        List<Entry> bucket = buckets.get(idx);

        for (Entry e : bucket) {
            if (e.key == key) {
                e.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    public int get(int key) {
        int idx = getIdx(key);
        for (Entry e : buckets.get(idx)) {
            if (e.key == key)
                return e.value;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = getIdx(key);
        List<Entry> bucket = buckets.get(idx);

        bucket.removeIf(e -> e.key == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */