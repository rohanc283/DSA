class Solution {
    boolean[] visited;
    boolean[] dfsVisited;
    int[] count;
    int maxCycleLen;

    private void DFS(int[] edges, int node) {
        if (node == -1)
            return;
        visited[node] = true;
        dfsVisited[node] = true;
        int neighbour = edges[node];
        if (neighbour != -1) {
            if (visited[neighbour]) {
                if (dfsVisited[neighbour]) {
                    maxCycleLen = Math.max(maxCycleLen, count[node] - count[neighbour] + 1);
                }
            } else {
                count[neighbour] = count[node] + 1;
                DFS(edges, neighbour);
            }
        }
        dfsVisited[node] = false;
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        visited = new boolean[n];
        dfsVisited = new boolean[n];
        count = new int[n];
        Arrays.fill(count, 1);
        maxCycleLen = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(edges, i);
            }
        }
        return maxCycleLen;
    }
}