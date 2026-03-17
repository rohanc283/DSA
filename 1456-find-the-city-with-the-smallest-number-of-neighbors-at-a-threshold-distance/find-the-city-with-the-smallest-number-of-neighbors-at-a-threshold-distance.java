class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                dist[i][i] = 0;
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        int resIdx = -1, resCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currCount = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    currCount++;
                }
            }
            if (currCount <= resCount) {
                resIdx = i;
                resCount = currCount;
            }
        }
        return resIdx;
    }
}