class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    isWater[i][j] = -1;
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
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && isWater[nr][nc] != -1 && isWater[nr][nc] == 0) {
                        queue.offer(new int[] { nr, nc });
                        height[nr][nc] = height[r][c] + 1;
                        isWater[nr][nc] = -1;
                    }
                }
            }
        }
        return height;
    }
}