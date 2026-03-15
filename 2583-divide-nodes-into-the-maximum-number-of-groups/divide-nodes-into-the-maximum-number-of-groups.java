class Solution {
    private boolean BFSBipartite(int curr, int currColor, int[] color, List<List<Integer>> graph) {
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

    public boolean isBipartite(List<List<Integer>> graph) {
        int n = graph.size();
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                boolean bipartite = BFSBipartite(i, 1, color, graph);
                if (!bipartite)
                    return false;
            }
        }
        return true;
    }

    private int BFS(int curr, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(curr);
        visited[curr] = true;
        int level = 1;
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int f = queue.poll();
                for (int nei : graph.get(f)) {
                    if (!visited[nei]) {
                        queue.offer(nei);
                        visited[nei] = true;
                    }
                }
            }
            level++;
        }
        return level - 1;
    }

    private int getMaxFromEachComp(List<List<Integer>> graph, boolean[] visited, int curr, int[] levels) {
        int maxGroup = levels[curr];
        visited[curr] = true;
        for (int nei : graph.get(curr)) {
            if (!visited[nei]) {
                maxGroup = Math.max(maxGroup, getMaxFromEachComp(graph, visited, nei, levels));
            }
        }
        return maxGroup;
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        if (!isBipartite(graph))
            return -1;

        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = BFS(i, graph, n);
        }

        int res = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                res += getMaxFromEachComp(graph, visited, node, levels);
            }
        }
        return res;
    }
}