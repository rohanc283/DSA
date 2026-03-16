class Solution {
    int m, n;
    Queue<int[]> queue;
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    boolean[][] visited;

    private void DFS(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || grid[r][c] == 0)
            return;

        visited[r][c] = true;
        queue.offer(new int[] { r, c });

        for (int[] d : dir)
            DFS(grid, r + d[0], c + d[1]);
    }

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        queue = new ArrayDeque<>();
        visited = new boolean[m][n];

        boolean found = false;

        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    DFS(grid, i, j);
                    found = true;
                    break;
                }
            }
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])
                        continue;

                    if (grid[nr][nc] == 1)
                        return steps;

                    queue.offer(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}