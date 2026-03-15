class Solution {
    private void DFS(int ancestor, List<List<Integer>> graph, int curr, List<List<Integer>> result, boolean[] visited) {
        for (int nei : graph.get(curr)) {
            if (!visited[nei]) {
                visited[nei] = true;
                if (result.get(nei).isEmpty() || result.get(nei).get(result.get(nei).size() - 1) != ancestor) {
                    result.get(nei).add(ancestor);
                }
                DFS(ancestor, graph, nei, result, visited);
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
        }
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            DFS(i, graph, i, result, visited);
        }
        return result;
    }
}