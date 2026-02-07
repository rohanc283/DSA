class MyHashSet {
    List<List<Integer>> buckets;
    int N;

    public MyHashSet() {
        buckets = new ArrayList<>();
        N = 15000;
        for (int i = 0; i < N; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int getIdx(int key) {
        return ((key % N) + N) % N;
    }

    public void add(int key) {
        int idx = getIdx(key);
        if (!buckets.get(idx).contains(key)) {
            buckets.get(idx).add(key);
        }
    }

    public void remove(int key) {
        int idx = getIdx(key);
        if (buckets.get(idx).contains(key)) {
            buckets.get(idx).remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int idx = getIdx(key);
        return buckets.get(idx).contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */