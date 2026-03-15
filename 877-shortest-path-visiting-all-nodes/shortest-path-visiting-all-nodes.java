class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] { i, 1 << i });
            visited[i][1 << i] = true;
        }
        int path = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0], state = curr[1];
                if (state == (1 << n) - 1)
                    return path;
                for (int nei : graph[node]) {
                    int nextMask = state | (1 << nei);
                    if (!visited[nei][nextMask]) {
                        queue.offer(new int[] { nei, nextMask });
                        visited[nei][nextMask] = true;
                    }
                }
            }
            path++;
        }
        return path;
    }
}