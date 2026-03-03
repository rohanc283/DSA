class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { i, nums[i] });
        }
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            pq2.offer(pq.poll());
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq2.poll()[1];
        }
        return res;
    }
}