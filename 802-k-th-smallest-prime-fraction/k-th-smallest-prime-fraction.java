class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double v1 = 1.0 * arr[i];
                double v2 = 1.0 * arr[j];
                pq.offer(new double[] { v1, v2, v1 / v2 });
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        int[] res = new int[2];
        if (!pq.isEmpty()) {
            res[0] = (int) pq.peek()[0];
            res[1] = (int) pq.peek()[1];
        }
        return res;
    }
}