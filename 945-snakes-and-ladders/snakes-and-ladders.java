class Solution {
    private int[] getCoordinates(int num, int n) {
        int rowFromTop = (num - 1) / n;
        int col = (num - 1) % n;

        if (rowFromTop % 2 == 1)
            col = n - 1 - col;

        int row = n - 1 - rowFromTop;

        return new int[] { row, col };
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(1);
        visited[n - 1][0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n * n)
                    return steps;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;

                    if (next > n * n)
                        break;

                    int[] coord = getCoordinates(next, n);
                    int r = coord[0];
                    int c = coord[1];

                    if (visited[r][c])
                        continue;

                    visited[r][c] = true;

                    if (board[r][c] == -1)
                        queue.offer(next);
                    else
                        queue.offer(board[r][c]);
                }
            }
            steps++;
        }
        return -1;
    }
}