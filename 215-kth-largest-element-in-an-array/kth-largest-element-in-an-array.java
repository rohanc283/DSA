class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() >= k) {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            } else {
                pq.offer(num);
            }
        }
        return pq.size() > 0 ? pq.peek() : -1;
    }
}