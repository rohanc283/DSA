class Solution {
    public int bruteForce(int[][] grid) {
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

    public int optimized(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(",");
            }
            String rowKey = sb.toString();
            map.put(rowKey, map.getOrDefault(rowKey, 0) + 1);
        }

        int res = 0;

        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]).append(",");
            }
            String colKey = sb.toString();
            res += map.getOrDefault(colKey, 0);
        }

        return res;
    }

    public int equalPairs(int[][] grid) {
        return optimized(grid);
    }
}