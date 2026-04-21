class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            int r = 0, c = i;
            while (r < m) {
                if (c < 0 || c >= n) {
                    c = -1;
                    break;
                }
                if (c + 1 < n && grid[r][c] == 1 && grid[r][c + 1] == -1) {
                    c = -1;
                    break;
                } else if (c - 1 >= 0 && grid[r][c] == -1 && grid[r][c - 1] == 1) {
                    c = -1;
                    break;
                } else {
                    c += grid[r][c];
                }
                r++;
            }
            res[i] = c == n ? -1 : c;
        }
        return res;
    }
}