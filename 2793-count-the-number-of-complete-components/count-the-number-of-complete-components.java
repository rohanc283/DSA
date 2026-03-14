class Solution {
    List<Integer>[] graph;
    boolean[] visited;

    private void DFS(int node, int[] vertices, int[] edges) {
        visited[node] = true;
        vertices[0]++;
        edges[0] += graph[node].size();
        for (Integer neighbour : graph[node]) {
            if (!visited[neighbour]) {
                DFS(neighbour, vertices, edges);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] e = new int[1];
                int[] v = new int[1];
                DFS(i, v, e);
                if ((v[0] * (v[0] - 1)) / 2 == e[0] / 2) {
                    count++;
                }
            }
        }
        return count;
    }
}