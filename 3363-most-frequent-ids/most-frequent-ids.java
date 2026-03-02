class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Long, Long> map = new HashMap<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[1], a[1]));
        int n = nums.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            long id = nums[i];
            long fr = freq[i];
            map.put(id, map.getOrDefault(id, 0L) + fr);
            pq.offer(new long[] { id, map.get(id) });
            while (!pq.isEmpty() && pq.peek()[1] != map.get(pq.peek()[0])) {
                pq.poll();
            }
            res[i] = pq.isEmpty() ? 0L : pq.peek()[1];
        }
        return res;
    }
}