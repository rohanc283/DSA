class Solution {
    private boolean won(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            boolean isValid = true;
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) != c) {
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            boolean isValid = true;
            for (int j = 0; j < 3; j++) {
                if (board[j].charAt(i) != c) {
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                return true;
        }

        boolean isValid = true;
        for (int i = 2; i >= 0; i--) {
            if (board[i].charAt(i) != c) {
                isValid = false;
                break;
            }
        }

        if (isValid)
            return true;

        isValid = true;
        for (int i = 2, j = 0; i >= 0 && j < 3; i--, j++) {
            if (board[i].charAt(j) != c) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X')
                    xCount++;
                else if (board[i].charAt(j) == 'O')
                    oCount++;
            }
        }
        System.out.println(xCount + " " + oCount);
        if (oCount > xCount)
            return false;
        if (Math.abs(xCount - oCount) >= 2)
            return false;
        boolean xWon = won(board, 'X');
        boolean oWon = won(board, 'O');
        if(xWon && oWon) return false;
        else if (xWon) {
            return xCount - oCount == 1;
        } else if (oWon) {
            return xCount == oCount;
        } else {
            System.out.println(xCount + " " + oCount);
            return xCount >= oCount;
        }
    }
}