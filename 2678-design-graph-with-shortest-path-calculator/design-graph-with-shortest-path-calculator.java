class Graph {

    int[][] graph;
    int n;

    private void floydWarshall(int[][] graph) {
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (graph[i][via] == Integer.MAX_VALUE || graph[via][j] == Integer.MAX_VALUE)
                        continue;

                    graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
                }
            }
        }
    }

    public Graph(int n, int[][] edges) {
        this.n = n;
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int[] e : edges) {
            int s = e[0], t = e[1], c = e[2];
            graph[s][t] = Math.min(graph[s][t], c);
        }

        floydWarshall(graph);
    }

    public void addEdge(int[] edge) {
        int u = edge[0], v = edge[1], c = edge[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (graph[i][u] != Integer.MAX_VALUE && graph[v][j] != Integer.MAX_VALUE) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][u] + c + graph[v][j]);
                }
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        return graph[node1][node2] == Integer.MAX_VALUE ? -1 : graph[node1][node2];
    }
}