class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][1 << n];

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        int path = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int mask = curr[1];

                if (mask == (1 << n) - 1)
                    return path;

                for (int nei : graph[node]) {
                    int nextMask = mask | (1 << nei);

                    if (!visited[nei][nextMask]) {
                        visited[nei][nextMask] = true;
                        queue.offer(new int[]{nei, nextMask});
                    }
                }
            }
            path++;
        }

        return -1;
    }
}