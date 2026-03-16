class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] res = new int[m][n];

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int[] f = queue.poll();
                int r = f[0], c = f[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == 1) {
                        queue.offer(new int[] { nr, nc });
                        res[nr][nc] = res[r][c] + 1;
                        mat[nr][nc] = 0;
                    }
                }
            }
        }
        return res;
    }
}