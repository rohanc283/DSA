class Solution {
    int[][] dir = {
            { 0, 1 }, // right
            { 0, -1 }, // left
            { 1, 0 }, // down
            { -1, 0 }, // up
            { 1, 1 }, // down-right
            { 1, -1 }, // down-left
            { -1, 1 }, // up-right
            { -1, -1 } // up-left
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;
        int[][] len = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(len[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { 0, 0, 1 });
        len[0][0] = 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], cost = cur[2];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == 1)
                    continue;

                if (cost + 1 < len[nr][nc]) {
                    len[nr][nc] = cost + 1;
                    pq.offer(new int[] { nr, nc, cost + 1 });
                }
            }
        }
        return len[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : len[m - 1][n - 1];
    }
}