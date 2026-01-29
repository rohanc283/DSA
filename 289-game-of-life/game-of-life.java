class Solution {
    public boolean canCellLiveMore(int[][] board, int m, int n, int i, int j) {
        int liveCellCount = 0;
        int[] iPos = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] jPos = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int x = 0; x < 8; x++) {
            int r = i + iPos[x], c = j + jPos[x];
            if (r < 0 || r >= m || c < 0 || c >= n)
                continue;

            if (board[r][c] == 1)
                liveCellCount++;
        }
        return liveCellCount == 2 || liveCellCount == 3;
    }

    public boolean canDeadCellLive(int[][] board, int m, int n, int i, int j) {
        int liveCellCount = 0;
        int[] iPos = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] jPos = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int x = 0; x < 8; x++) {
            int r = i + iPos[x], c = j + jPos[x];
            if (r < 0 || r >= m || c < 0 || c >= n)
                continue;
            if (board[r][c] == 1)
                liveCellCount++;
        }
        return liveCellCount == 3;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] res = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board[i][j] == 1) {
                    res[i][j] = canCellLiveMore(board, m, n, i, j) ? 1 : 0;
                } else {
                    res[i][j] = canDeadCellLive(board, m, n, i, j) ? 1 : 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                board[i][j] = res[i][j];
            }
        }
    }
}