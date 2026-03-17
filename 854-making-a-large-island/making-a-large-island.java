class Solution {

    int n;
    int[][] grid;
    Map<Integer, Integer> map = new HashMap<>();

    private int dfs(int i, int j, int id) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1)
            return 0;

        grid[i][j] = id;

        int size = 1;

        size += dfs(i + 1, j, id);
        size += dfs(i - 1, j, id);
        size += dfs(i, j + 1, id);
        size += dfs(i, j - 1, id);

        return size;
    }

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;

        int id = 2;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(i, j, id);
                    map.put(id, size);
                    max = Math.max(max, size);
                    id++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {

                    Set<Integer> seen = new HashSet<>();
                    int currSize = 1;

                    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

                    for (int[] d : dirs) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && nj >= 0 && ni < n && nj < n) {
                            int islandId = grid[ni][nj];

                            if (islandId > 1 && !seen.contains(islandId)) {
                                currSize += map.get(islandId);
                                seen.add(islandId);
                            }
                        }
                    }

                    max = Math.max(max, currSize);
                }
            }
        }
        return max;
    }
}