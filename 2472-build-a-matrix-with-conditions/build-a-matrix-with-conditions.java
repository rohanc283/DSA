class Solution {

    private boolean dfs(int node, List<List<Integer>> graph, int[] state, List<Integer> topo) {
        if (state[node] == 1)
            return false;

        if (state[node] == 2)
            return true;

        state[node] = 1;

        for (int nei : graph.get(node)) {
            if (!dfs(nei, graph, state, topo))
                return false;
        }

        state[node] = 2;
        topo.add(node);
        return true;
    }

    private List<Integer> topoSortDFS(int[][] edges, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            graph.get(u).add(v);
        }

        int[] state = new int[k];
        List<Integer> topo = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (state[i] == 0) {
                if (!dfs(i, graph, state, topo))
                    return new ArrayList<>();
            }
        }
        Collections.reverse(topo);
        return topo;
    }

    private List<Integer> topoSortBFS(int[][] edges, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[k];

        for (int i = 0; i < k; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++)
            if (indegree[i] == 0)
                queue.offer(i);

        List<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);

            for (int nei : graph.get(u)) {
                indegree[nei]--;
                if (indegree[nei] == 0)
                    queue.offer(nei);
            }
        }

        if (topo.size() != k)
            return new ArrayList<>();

        return topo;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        List<Integer> topoRow = topoSortBFS(rowConditions, k);
        List<Integer> topoCol = topoSortBFS(colConditions, k);

        if (topoRow.isEmpty() || topoCol.isEmpty())
            return new int[0][0];

        int[][] matrix = new int[k][k];

        int[] colIndex = new int[k];
        for (int i = 0; i < k; i++)
            colIndex[topoCol.get(i)] = i;

        for (int i = 0; i < k; i++) {
            int num = topoRow.get(i);
            matrix[i][colIndex[num]] = num + 1;
        }

        return matrix;
    }
}