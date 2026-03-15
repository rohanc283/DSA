class Solution {

    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int ans = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int[] dist = new int[n];
            int[] parent = new int[n];

            Arrays.fill(dist, -1);

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(start);
            dist[start] = 0;
            parent[start] = -1;

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int nei : graph.get(curr)) {
                    if (dist[nei] == -1) {
                        dist[nei] = dist[curr] + 1;
                        parent[nei] = curr;
                        q.offer(nei);
                    } else if (parent[curr] != nei) {
                        ans = Math.min(ans, dist[curr] + dist[nei] + 1);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}