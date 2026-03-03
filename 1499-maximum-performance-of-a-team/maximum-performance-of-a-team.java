class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }

        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long speedSum = 0;
        long maxPerf = 0;
        long MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            pq.offer(engineers[i][0]);
            speedSum += engineers[i][0];

            if (pq.size() > k) {
                speedSum -= pq.poll();
            }

            maxPerf = Math.max(maxPerf, speedSum * engineers[i][1]);
        }

        return (int) (maxPerf % MOD);
    }
}