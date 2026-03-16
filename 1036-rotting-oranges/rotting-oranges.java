class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = grid.length, n = grid[0].length;
        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int minute = 0;
        if (freshOranges == 0)
            return 0;
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int[] f = queue.poll();
                int r = f[0], c = f[1];
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        queue.offer(new int[] { nr, nc });
                        grid[nr][nc] = 2;
                        freshOranges--;
                    }
                }
            }
            minute++;
        }
        return freshOranges == 0 ? minute - 1 : -1;
    }
}