class Solution {
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int m, n;
    Integer[][] dp;

    private int solve(int[][] grid, int r, int c, boolean[][] vis) {
        if (r == m - 1 && c == n - 1)
            return 0;

        vis[r][c] = true;

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc])
                continue;

            int extraCost = (grid[r][c] == i + 1) ? 0 : 1;

            int next = solve(grid, nr, nc, vis);

            if (next != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, extraCost + next);
            }
        }

        vis[r][c] = false;

        return minCost;
    }

    private int sol1(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        return solve(grid, 0, 0, vis);
    }

    private int sol2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[] { 0, 0, 0 });
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], cost = cur[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int gridDir = grid[r][c];
                int dirCost = (gridDir == i + 1) ? 0 : 1;

                int newCost = cost + dirCost;
                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new int[] { nr, nc, newCost });
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    public int minCost(int[][] grid) {
        return sol2(grid);
    }
}