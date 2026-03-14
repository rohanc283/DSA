class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        Queue<int[]> queue = new ArrayDeque<>();
        int totalKeys = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    queue.offer(new int[] { i, j, 0, 0 });
                } else if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    totalKeys++;
                }
            }
        }
        int finalKeyStatus = (1 << totalKeys) - 1;
        int[][][] visited = new int[m][n][finalKeyStatus + 1];
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int i = front[0], j = front[1], steps = front[2], currKeyStatus = front[3];
            if (currKeyStatus == finalKeyStatus)
                return steps;

            for (int[] d : dir) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni].charAt(nj) != '#') {
                    char ch = grid[ni].charAt(nj);
                    if (ch >= 'A' && ch <= 'F') {
                        if (visited[ni][nj][currKeyStatus] == 0 && ((currKeyStatus >> (ch - 'A')) & 1) == 1) {
                            queue.offer(new int[] { ni, nj, steps + 1, currKeyStatus });
                            visited[ni][nj][currKeyStatus] = 1;
                        }
                    } else if (ch >= 'a' && ch <= 'f') {
                        int newKeyStatus = currKeyStatus | (1 << (ch - 'a'));
                        if (visited[ni][nj][newKeyStatus] == 0) {
                            queue.offer(new int[] { ni, nj, steps + 1, newKeyStatus });
                            visited[ni][nj][newKeyStatus] = 1;
                        }
                    } else {
                        if (visited[ni][nj][currKeyStatus] == 0) {
                            queue.offer(new int[] { ni, nj, steps + 1, currKeyStatus });
                            visited[ni][nj][currKeyStatus] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}