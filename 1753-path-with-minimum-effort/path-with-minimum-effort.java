class Solution {
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length, n = heights[0].length;

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[] { 0, 0, 0 });
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], effort = cur[2];

            if (r == m - 1 && c == n - 1)
                return effort;

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int edgeCost = Math.abs(heights[r][c] - heights[nr][nc]);

                int newEffort = Math.max(effort, edgeCost);

                if (dist[nr][nc] > newEffort) {
                    dist[nr][nc] = newEffort;
                    pq.offer(new int[] { nr, nc, newEffort });
                }
            }
        }

        return 0;
    }
}