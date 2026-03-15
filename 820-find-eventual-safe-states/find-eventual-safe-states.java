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

    private List<Integer> sol2(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            reversedGraph.add(new ArrayList<>());

        int[] indegree = new int[V];
        for (int u = 0; u < graph.length; u++) {
            for (int v : graph[u]) {
                reversedGraph.get(v).add(u);
                indegree[u]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        boolean[] isSafe = new boolean[V];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            isSafe[u] = true;
            for (int nei : reversedGraph.get(u)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isSafe[i])
                safeNodes.add(i);
        }
        return safeNodes;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        return sol2(graph);
    }
}