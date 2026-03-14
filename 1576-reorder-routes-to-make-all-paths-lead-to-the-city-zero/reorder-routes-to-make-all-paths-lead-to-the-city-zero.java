class Solution {
    List<int[]>[] graph;
    int count;

    private void DFS(int node, int parent) {
        for (int[] neighbour : graph[node]) {
            if (neighbour[0] != parent) {
                if (neighbour[1] == 1) {
                    count++;
                }
                DFS(neighbour[0], node);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : connections) {
            graph[e[0]].add(new int[] { e[1], 1 });
            graph[e[1]].add(new int[] { e[0], 0 });
        }
        count = 0;
        DFS(0, -1);
        return count;
    }
}