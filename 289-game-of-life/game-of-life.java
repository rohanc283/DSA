class Solution {

    private static final int[] DIR = { -1, 0, 1 };

    private int countLiveNeighbors(int[][] board, int m, int n, int i, int j) {
        int count = 0;

        for (int di : DIR) {
            for (int dj : DIR) {
                if (di == 0 && dj == 0)
                    continue;

                int r = i + di, c = j + dj;
                if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] next = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, m, n, i, j);

                if (board[i][j] == 1) {
                    next[i][j] = (liveNeighbors == 2 || liveNeighbors == 3) ? 1 : 0;
                } else {
                    next[i][j] = (liveNeighbors == 3) ? 1 : 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.arraycopy(next[i], 0, board[i], 0, n);
        }
    }
}
