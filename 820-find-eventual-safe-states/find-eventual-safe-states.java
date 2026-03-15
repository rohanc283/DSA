class Solution {
    boolean[] visited;
    boolean[] dfsVisited;

    private boolean isCycleDFS(int node, int[][] graph) {
        visited[node] = true;
        dfsVisited[node] = true;
        for (int neighbour : graph[node]) {
            if (dfsVisited[neighbour])
                return true;
            else if (!visited[neighbour]) {
                boolean hasCycle = isCycleDFS(neighbour, graph);
                if (hasCycle)
                    return true;
            }
        }
        dfsVisited[node] = false;
        return false;
    }

    private List<Integer> sol1(int[][] graph) {
        int V = graph.length;
        visited = new boolean[V];
        dfsVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                isCycleDFS(i, graph);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!dfsVisited[i])
                safeNodes.add(i);
        }
        return safeNodes;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        return sol1(graph);
    }
}