class Solution {
    private boolean BFS(int curr, int currColor, int[] color, List<List<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(curr);
        color[curr] = currColor;
        while (!queue.isEmpty()) {
            int f = queue.poll();
            for (int nei : graph.get(f)) {
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

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : dislikes) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                boolean bipartite = BFS(i, 1, color, graph);
                if (!bipartite)
                    return false;
            }
        }
        return true;
    }
}