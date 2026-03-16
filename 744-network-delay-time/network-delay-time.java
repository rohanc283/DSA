class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int u = t[0] - 1, v = t[1] - 1, w = t[2];
            graph.get(u).add(new int[] { v, w });
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] { k - 1, 0 });
        while (!pq.isEmpty()) {
            int[] f = pq.poll();
            int u = f[0], d = f[1];
            for (int[] nei : graph.get(u)) {
                int v = nei[0], vd = nei[1];
                if (d + vd < dist[v]) {
                    dist[v] = d + vd;
                    pq.offer(new int[] { v, d + vd });
                }
            }
        }
        int ans = 0;
        for (int d : dist)
            ans = Math.max(ans, d);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}