class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int i = 0, j = n - 1;
        long res = 0;
        while (k > 0) {
            while (i <= j && pq1.size() < candidates) {
                pq1.offer(costs[i++]);
            }
            while (i <= j && pq2.size() < candidates) {
                pq2.offer(costs[j--]);
            }
            int v1 = pq1.isEmpty() ? Integer.MAX_VALUE : pq1.peek();
            int v2 = pq2.isEmpty() ? Integer.MAX_VALUE : pq2.peek();
            if (v1 <= v2) {
                res += v1;
                pq1.poll();
            } else {
                res += v2;
                pq2.poll();
            }
            k--;
        }
        return res;
    }
}