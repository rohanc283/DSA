class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                set.add(grid[r][c]);
                if (set.size() > 3)
                    set.pollFirst();

                for (int side = 1; r - side >= 0 && r + side < m && c - side >= 0 && c + side < n; side++) {
                    int sum = 0;
                    for (int k = 0; k <= side - 1; k++) {
                        sum += grid[r - side + k][c + k];
                        sum += grid[r + k][c + side - k];
                        sum += grid[r + side - k][c - k];
                        sum += grid[r - k][c - side + k];

                    }
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