class Solution {
    public int countNegatives(int[][] grid) {
        int r = 0, c = grid[0].length - 1;
        int count = 0;

        while (r < grid.length && c >= 0) {
            if (grid[r][c] < 0) {
                count += (grid.length - r);
                c--;
            } else {
                r++;
            }
        }

        return count;
    }
}