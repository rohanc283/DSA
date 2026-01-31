class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];

        for (int c = 0; c < n; c++) {
            int col = c;

            for (int row = 0; row < m; row++) {
                int dir = grid[row][col];
                int nextCol = col + dir;

                if (nextCol < 0 || nextCol >= n || grid[row][nextCol] != dir) {
                    col = -1;
                    break;
                }

                col = nextCol;
            }

            res[c] = col;
        }

        return res;
    }
}