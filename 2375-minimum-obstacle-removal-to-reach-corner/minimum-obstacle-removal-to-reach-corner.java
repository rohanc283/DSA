class Solution {
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] obs = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(obs[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { 0, 0, 0 });
        obs[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], cost = cur[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int nextCost = grid[nr][nc] == 1 ? 1 : 0;
                if (cost + nextCost < obs[nr][nc]) {
                    obs[nr][nc] = cost + nextCost;
                    pq.offer(new int[] { nr, nc, cost + nextCost });
                }
            }
        }
        return obs[m - 1][n - 1];
    }
}