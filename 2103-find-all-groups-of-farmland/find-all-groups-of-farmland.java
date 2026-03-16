class Solution {
    int m, n;
    List<List<Integer>> result;
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void DFS(int[][] land, int i, int j, int[] r2, int[] c2) {
        land[i][j] = 0;
        r2[0] = Math.max(r2[0], i);
        c2[0] = Math.max(c2[0], j);
        for (int[] d : dir) {
            int nr = i + d[0];
            int nc = j + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && land[nr][nc] == 1) {
                DFS(land, nr, nc, r2, c2);
            }
        }
    }

    private void BFS(int[][] land, int i, int j, int[] r2, int[] c2) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j });
        land[i][j] = 0;
        while (!queue.isEmpty()) {
            int[] f = queue.poll();
            i = f[0];
            j = f[1];
            r2[0] = Math.max(r2[0], i);
            c2[0] = Math.max(c2[0], j);
            for (int[] d : dir) {
                int nr = i + d[0];
                int nc = j + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && land[nr][nc] == 1) {
                    queue.offer(new int[] { nr, nc });
                    land[nr][nc] = 0;
                }
            }
        }
    }

    public int[][] sol1(int[][] land) {
        m = land.length;
        n = land[0].length;
        result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int r1 = i, c1 = j;
                    int[] r2 = new int[1];
                    int[] c2 = new int[1];
                    BFS(land, i, j, r2, c2);
                    result.add(new ArrayList<>(Arrays.asList(r1, c1, r2[0], c2[0])));
                }
            }
        }
        return result.stream()
                .map(l -> l.stream().mapToInt(i -> i).toArray())
                .toArray(int[][]::new);
    }

    public int[][] findFarmland(int[][] land) {
        return sol1(land);
    }
}