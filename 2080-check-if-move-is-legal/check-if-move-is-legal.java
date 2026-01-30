class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[] dir = { -1, 0, 1 };
        for (int x : dir) {
            for (int y : dir) {
                if (x == 0 && y == 0)
                    continue;
                int r = rMove + x, c = cMove + y;
                int wCount = 0, bCount = 0;
                if (color == 'B') {
                    while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                        if (board[r][c] == '.')
                            break;
                        else if (board[r][c] == 'W')
                            wCount++;
                        else {
                            if (wCount > 0)
                                return true;
                            else {
                                break;
                            }
                        }
                        r += x;
                        c += y;
                    }
                } else {
                    while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                        if (board[r][c] == '.')
                            break;
                        else if (board[r][c] == 'B')
                            bCount++;
                        else {
                            if (bCount > 0)
                                return true;
                            else {
                                break;
                            }
                        }
                        r += x;
                        c += y;
                    }
                }
            }
        }
        return false;
    }
}