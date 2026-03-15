class Solution {
    List<List<Integer>> graph;

    private int BFS(int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> parent = new HashMap<>();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        queue.offer(start);
        visited[start] = true;
        parent.put(start, -1);
        dist[start] = 0;

        int ans = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int nei : graph.get(curr)) {
                if (!visited[nei]) {
                    queue.offer(nei);
                    visited[nei] = true;
                    parent.put(nei, curr);
                    dist[nei] = dist[curr] + 1;
                } else if (parent.get(curr) != nei) {
                    ans = Math.min(ans, dist[curr] + dist[nei] + 1);
                }
            }
        }
        return ans;
    }

    public int findShortestCycle(int n, int[][] edges) {
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, BFS(i, n));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}