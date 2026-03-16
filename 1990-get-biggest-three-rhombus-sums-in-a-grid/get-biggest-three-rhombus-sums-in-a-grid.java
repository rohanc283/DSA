class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int[][] d1 = new int[m][n]; 
        int[][] d2 = new int[m][n]; 

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                d1[r][c] = grid[r][c];
                d2[r][c] = grid[r][c];

                if (r > 0 && c > 0)
                    d1[r][c] += d1[r - 1][c - 1];

                if (r > 0 && c < n - 1)
                    d2[r][c] += d2[r - 1][c + 1];
            }
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                set.add(grid[r][c]);
                if (set.size() > 3)
                    set.pollFirst();

                for (int side = 1; r - side >= 0 && r + side < m && c - side >= 0 && c + side < n; side++) {

                    int top_r = r - side, top_c = c;
                    int right_r = r, right_c = c + side;
                    int bottom_r = r + side, bottom_c = c;
                    int left_r = r, left_c = c - side;

                    int sum = 0;

                    // top -> right
                    sum += d1[right_r][right_c] -
                            (top_r - 1 >= 0 && top_c - 1 >= 0 ? d1[top_r - 1][top_c - 1] : 0);

                    // right -> bottom
                    sum += d2[bottom_r][bottom_c] -
                            (right_r - 1 >= 0 && right_c + 1 < n ? d2[right_r - 1][right_c + 1] : 0);

                    // bottom -> left
                    sum += d1[bottom_r][bottom_c] -
                            (left_r - 1 >= 0 && left_c - 1 >= 0 ? d1[left_r - 1][left_c - 1] : 0);

                    // left -> top
                    sum += d2[left_r][left_c] -
                            (top_r - 1 >= 0 && top_c + 1 < n ? d2[top_r - 1][top_c + 1] : 0);

                    // subtract duplicated corners
                    sum -= grid[top_r][top_c];
                    sum -= grid[right_r][right_c];
                    sum -= grid[bottom_r][bottom_c];
                    sum -= grid[left_r][left_c];

                    set.add(sum);
                    if (set.size() > 3)
                        set.pollFirst();
                }
            }
        }

        int[] res = new int[set.size()];
        int i = set.size() - 1;

        for (int val : set)
            res[i--] = val;

        return res;
    }
}