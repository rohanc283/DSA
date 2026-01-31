class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean allEqual = true;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        allEqual = false;
                        break;
                    }
                }
                if (allEqual)
                    res++;
            }
        }
        return res;
    }
}