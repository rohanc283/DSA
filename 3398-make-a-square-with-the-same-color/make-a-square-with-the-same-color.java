class Solution {
    public boolean checkUpperLeft(char[][] grid, int i, int j) {
        int bCount = 0, wCount = 0;
        if (i - 1 >= 0) {
            if (grid[i - 1][j] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (i - 1 >= 0 && j - 1 >= 0) {
            if (grid[i - 1][j - 1] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (j - 1 >= 0) {
            if (grid[i][j - 1] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (grid[i][j] == 'B') {
            return 1 + bCount + 1 >= 4;
        } else {
            return 1 + wCount + 1 >= 4;
        }
    }

    public boolean checkUpperRight(char[][] grid, int i, int j) {
        int bCount = 0, wCount = 0;
        if (i - 1 >= 0) {
            if (grid[i - 1][j] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (i - 1 >= 0 && j + 1 < 3) {
            if (grid[i - 1][j + 1] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (j + 1 < 3) {
            if (grid[i][j + 1] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (grid[i][j] == 'B') {
            return 1 + bCount + 1 >= 4;
        } else {
            return 1 + wCount + 1 >= 4;
        }
    }

    public boolean checkLowerLeft(char[][] grid, int i, int j) {
        int bCount = 0, wCount = 0;
        if (i + 1 < 3) {
            if (grid[i + 1][j] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (i + 1 < 3 && j - 1 >= 0) {
            if (grid[i + 1][j - 1] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (j - 1 >= 0) {
            if (grid[i][j - 1] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (grid[i][j] == 'B') {
            return 1 + bCount + 1 >= 4;
        } else {
            return 1 + wCount + 1 >= 4;
        }
    }

    public boolean checkLowerRight(char[][] grid, int i, int j) {
        int bCount = 0, wCount = 0;
        if (i + 1 < 3) {
            if (grid[i + 1][j] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (i + 1 < 3 && j + 1 < 3) {
            if (grid[i + 1][j + 1] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (j + 1 < 3) {
            if (grid[i][j + 1] == 'B')
                bCount++;
            else
                wCount++;
        }

        if (grid[i][j] == 'B') {
            return 1 + bCount + 1 >= 4;
        } else {
            return 1 + wCount + 1 >= 4;
        }
    }

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // check upper matrix
                if (checkUpperLeft(grid, i, j) || checkLowerLeft(grid, i, j)
                        || checkUpperRight(grid, i, j) || checkLowerRight(grid, i, j))
                    return true;
            }
        }
        return false;
    }
}