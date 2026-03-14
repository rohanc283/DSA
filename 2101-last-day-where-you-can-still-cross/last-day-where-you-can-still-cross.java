class Solution {
    private boolean isPoss(int row, int col, int[][] cells, int m) {
        boolean[][] water = new boolean[row][col];

        for (int i = 0; i < m; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            water[r][c] = true;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];

        for (int c = 0; c < col; c++) {
            if (!water[0][c]) {
                q.offer(new int[] { 0, c });
                visited[0][c] = true;
            }
        }

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == row - 1)
                return true;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < row && nc < col &&
                        !water[nr][nc] && !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    q.offer(new int[] { nr, nc });
                }
            }
        }

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        int l = 1, h = n;
        int res = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(row, col, cells, m)) {
                res = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return res;
    }
}