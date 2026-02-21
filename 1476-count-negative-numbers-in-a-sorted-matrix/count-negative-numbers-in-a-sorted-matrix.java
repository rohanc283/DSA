class Solution {
    public int countNegatives(int[][] grid) {
        int r = grid.length - 1, sc = 0, ec = grid[0].length - 1;
        int res = 0;
        while (r >= 0) {
            while (sc <= ec) {
                int m = sc + (ec - sc) / 2;
                if (grid[r][m] < 0) {
                    ec = m - 1;
                } else {
                    sc = m + 1;
                }
            }
            res += (grid[0].length - sc);
            ec = grid[0].length - 1;
            r--;
        }
        return res;
    }
}