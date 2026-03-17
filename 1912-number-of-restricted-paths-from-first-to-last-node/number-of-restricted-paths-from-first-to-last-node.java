class Solution {
    int MOD = 1_000_000_007;

    private int[] dijkstra(int n, List<List<int[]>> graph) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[] { n - 1, 0 });
        dist[n - 1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];

            if (d > dist[u])
                continue;

            for (int[] nei : graph.get(u)) {
                int v = nei[0], w = nei[1];
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[] { v, dist[v] });
                }
            }
        }
        return dist;
    }

    private int dfs(int u, List<List<int[]>> graph, int[] dist, Integer[] dp) {
        if (u == dist.length - 1)
            return 1;

        if (dp[u] != null)
            return dp[u];

        long ways = 0;

        for (int[] nei : graph.get(u)) {
            int v = nei[0];

            if (dist[u] > dist[v]) {
                ways = (ways + dfs(v, graph, dist, dp)) % MOD;
            }
        }

        return dp[u] = (int) ways;
    }

    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1, w = e[2];
            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }

        int[] dist = dijkstra(n, graph);

        Integer[] dp = new Integer[n];

        return dfs(0, graph, dist, dp);
    }
}