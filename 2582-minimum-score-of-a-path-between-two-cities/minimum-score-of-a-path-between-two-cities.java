class Solution {

    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] r : roads) {
            graph[r[0]].add(new int[] { r[1], r[2] });
            graph[r[1]].add(new int[] { r[0], r[2] });
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(1);
        visited[1] = true;

        int minEdge = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int[] nei : graph[node]) {
                int next = nei[0];
                int weight = nei[1];

                minEdge = Math.min(minEdge, weight);

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return minEdge;
    }
}