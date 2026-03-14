class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.computeIfAbsent(u, l -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, l -> new ArrayList<>()).add(u);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int f = queue.poll();
            if (f == destination)
                return true;
            for (Integer neighbour : graph.get(f)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return false;
    }
}