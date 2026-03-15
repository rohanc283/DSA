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

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                boolean bipartite = DFS(i, 1, color, graph);
                if (!bipartite)
                    return false;
            }
        }
        return true;
    }
}