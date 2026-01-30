class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {

        int[] dir = { -1, 0, 1 };
        char opp = (color == 'B') ? 'W' : 'B';

        for (int dx : dir) {
            for (int dy : dir) {
                if (dx == 0 && dy == 0)
                    continue;

                int r = rMove + dx, c = cMove + dy;
                boolean seenOpp = false;

                while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                    if (board[r][c] == '.')
                        break;

                    if (board[r][c] == opp) {
                        seenOpp = true;
                    } else {
                        if (seenOpp)
                            return true;
                        break;
                    }

                    r += dx;
                    c += dy;
                }
            }
        }
        return false;
    }
}
