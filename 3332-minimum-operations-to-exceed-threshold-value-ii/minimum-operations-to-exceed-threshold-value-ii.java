class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(1L * num);
        }
        int operations = 0;
        while (pq.size() > 1 && pq.peek() < k) {
            long x = pq.poll(), y = pq.poll();
            pq.offer(Math.min(x, y) * 2 + Math.max(x, y));
            operations++;
        }
        if (pq.peek() >= k)
            return operations;
        return -1;
    }
}