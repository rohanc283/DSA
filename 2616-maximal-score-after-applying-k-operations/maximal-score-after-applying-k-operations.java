class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums)
            pq.offer(num);
        long res = 0;
        for (int i = 0; i < k; i++) {
            int top = pq.poll();
            res += top;
            int next = (int) Math.ceil((1.0 * top) / (1.0 * 3));
            pq.offer(next);
        }
        return res;
    }
}