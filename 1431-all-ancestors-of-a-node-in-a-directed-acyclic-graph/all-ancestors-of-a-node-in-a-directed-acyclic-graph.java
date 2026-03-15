class Solution {
    private void DFSSol1(int ancestor, List<List<Integer>> graph, int curr, List<List<Integer>> result,
            boolean[] visited) {
        for (int nei : graph.get(curr)) {
            if (!visited[nei]) {
                visited[nei] = true;
                if (result.get(nei).isEmpty() || result.get(nei).get(result.get(nei).size() - 1) != ancestor) {
                    result.get(nei).add(ancestor);
                }
                DFSSol1(ancestor, graph, nei, result, visited);
            }
        }
    }

    private List<List<Integer>> sol1(int n, int[][] edges) {
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
            DFSSol1(i, graph, i, result, visited);
        }
        return result;
    }

    private void DFSSol2(List<List<Integer>> graph, int curr, boolean[] visited) {
        for (int nei : graph.get(curr)) {
            if (!visited[nei]) {
                visited[nei] = true;
                DFSSol2(graph, nei, visited);
            }
        }
    }

    private List<List<Integer>> sol2(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            DFSSol2(graph, i, visited);
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    result.get(i).add(j);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        return sol2(n, edges);
    }
}