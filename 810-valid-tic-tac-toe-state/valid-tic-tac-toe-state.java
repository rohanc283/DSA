class Solution {
    public boolean checkWon(String[] board, char ch) {

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch &&
                    board[i].charAt(1) == ch &&
                    board[i].charAt(2) == ch)
                return true;
        }

        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == ch &&
                    board[1].charAt(j) == ch &&
                    board[2].charAt(j) == ch)
                return true;
        }

        if (board[0].charAt(0) == ch &&
                board[1].charAt(1) == ch &&
                board[2].charAt(2) == ch)
            return true;

        if (board[0].charAt(2) == ch &&
                board[1].charAt(1) == ch &&
                board[2].charAt(0) == ch)
            return true;

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

        if (oCount > xCount || xCount - oCount > 1)
            return false;

        boolean xWon = checkWon(board, 'X');
        boolean oWon = checkWon(board, 'O');

        if (xWon && oWon)
            return false;

        if (xWon)
            return xCount == oCount + 1;
        if (oWon)
            return xCount == oCount;

        return true;
    }

}