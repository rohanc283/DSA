class Solution {
    public boolean checkWon(String[] board, char ele) {
        int[] dir = { -1, 0, 1 };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == ele) {
                    for (int x : dir) {
                        for (int y : dir) {
                            if (x == 0 && y == 0)
                                continue;
                            int r = i + x, c = j + y;
                            int count = 1;
                            while (r >= 0 && r < 3 && c >= 0 && c < 3) {
                                if (board[r].charAt(c) == ele) {
                                    count++;
                                    if (count == 3) {
                                        System.out.println(i + " " + j);
                                        return true;
                                    }
                                } else {
                                    break;
                                }
                                r += x;
                                c += y;
                            }

                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X')
                    xCount++;
                if (board[i].charAt(j) == 'O')
                    oCount++;
            }
        }

        if (oCount > xCount || xCount - 1 > oCount)
            return false;

        boolean xWon = checkWon(board, 'X');
        boolean oWon = checkWon(board, 'O');

        if (xWon && oWon)
            return false;

        if (xWon) {
            return xCount - 1 == oCount;
        } else if (oWon) {
            return oCount == xCount;
        }
        return true;
    }
}