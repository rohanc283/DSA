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

    private List<List<Integer>> sol3(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);
            for (int nei : graph.get(u)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        List<TreeSet<Integer>> mapping = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mapping.add(new TreeSet<>());
        }
        for (int node : topo) {
            for (int nei : graph.get(node)) {
                mapping.get(nei).add(node);
                mapping.get(nei).addAll(mapping.get(node));
            }
        }
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>(mapping.get(i)));
        }
        return result;
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        return sol3(n, edges);
    }
}