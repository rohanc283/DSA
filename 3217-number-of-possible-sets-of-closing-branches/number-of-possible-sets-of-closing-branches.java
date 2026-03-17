class Solution {
    private void floydWarshall(int n, int[][] graph) {
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (graph[i][via] == Integer.MAX_VALUE || graph[via][j] == Integer.MAX_VALUE)
                        continue;

                    graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
                }
            }
        }
    }

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int res = 0;
        for (int set = 0; set < 1 << n; set++) {
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(graph[i], Integer.MAX_VALUE);
                graph[i][i] = 0;
            }

            for (int[] e : roads) {
                int s = e[0], t = e[1], c = e[2];
                if (((set >> s) & 1) == 1 && ((set >> t) & 1) == 1) {
                    graph[s][t] = Math.min(graph[s][t], c);
                    graph[t][s] = Math.min(graph[t][s], c);
                }
            }

            floydWarshall(n, graph);


            boolean valid = true;
            for (int i = 0; i < n && valid; i++) {
                if (((set >> i) & 1) == 0) continue;

                for (int j = 0; j < n; j++) {
                    if (((set >> j) & 1) == 0) continue;
                    if (graph[i][j] > maxDistance) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) res++;
        }
        return res;
    }
}