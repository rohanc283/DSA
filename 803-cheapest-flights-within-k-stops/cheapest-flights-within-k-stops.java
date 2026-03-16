class Solution {
    private int BFS(List<List<int[]>> graph, int n, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { src, 0 });
        int steps = 0;
        while (!queue.isEmpty() && steps <= k) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int[] f = queue.poll();
                int u = f[0], c = f[1];
                for (int[] nei : graph.get(u)) {
                    int v = nei[0], cv = nei[1];
                    if (c + cv < cost[v]) {
                        cost[v] = c + cv;
                        queue.offer(new int[] { v, c + cv });
                    }
                }
            }
            steps++;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] f : flights) {
            int u = f[0], v = f[1], w = f[2];
            graph.get(u).add(new int[] { v, w });
        }
        return BFS(graph, n, src, dst, k);
    }
}