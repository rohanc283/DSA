class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(new int[] { heightMap[i][0], i, 0 });
            visited[i][0] = true;

            pq.offer(new int[] { heightMap[i][n - 1], i, n - 1 });
            visited[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { heightMap[0][i], 0, i });
            visited[0][i] = true;

            pq.offer(new int[] { heightMap[m - 1][i], m - 1, i });
            visited[m - 1][i] = true;
        }
        int water = 0;
        int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int height = cell[0];
            int i = cell[1];
            int j = cell[2];
            for (int[] dir : directions) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];
                if (i_ < m && j_ < n && i_ >= 0 && j_ >= 0 && !visited[i_][j_]) {
                    water += Math.max(height - heightMap[i_][j_], 0);
                    visited[i_][j_] = true;
                    pq.offer(new int[] { Math.max(height, heightMap[i_][j_]), i_, j_ });
                }
            }
        }
        return water;
    }
}