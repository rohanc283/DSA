class Solution {
    private boolean DFS(int curr, int currColor, int[] color, int[][] graph) {
        color[curr] = currColor;
        for (int nei : graph[curr]) {
            if (color[nei] == color[curr])
                return false;
            if (color[nei] == -1) {
                int newColor = 1 - currColor;
                boolean bipartite = DFS(nei, newColor, color, graph);
                if (!bipartite)
                    return false;
            }
        }
        return true;
    }

    private boolean BFS(int curr, int currColor, int[] color, int[][] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(curr);
        color[curr] = currColor;
        while (!queue.isEmpty()) {
            int f = queue.poll();
            for (int nei : graph[f]) {
                if (color[nei] == color[f]) {
                    return false;
                }
                if (color[nei] == -1) {
                    int newColor = 1 - color[f];
                    color[nei] = newColor;
                    queue.offer(nei);
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                boolean bipartite = BFS(i, 1, color, graph);
                if (!bipartite)
                    return false;
            }
        }
        return true;
    }
}