class Solution {

    private List<Integer> topoSort(int[][] edges, int k) {
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

        List<Integer> topoRow = topoSort(rowConditions, k);
        List<Integer> topoCol = topoSort(colConditions, k);

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