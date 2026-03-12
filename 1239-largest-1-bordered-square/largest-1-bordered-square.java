class Solution {

    public int largest1BorderedSquare(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] left = new int[rows][cols];
        int[][] up = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 1) {

                    if (c == 0)
                        left[r][c] = 1;
                    else
                        left[r][c] = left[r][c - 1] + 1;

                    if (r == 0)
                        up[r][c] = 1;
                    else
                        up[r][c] = up[r - 1][c] + 1;
                }
            }
        }

        int largestSide = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                int possibleSide = Math.min(left[r][c], up[r][c]);

                while (possibleSide > largestSide) {

                    int topRow = r - possibleSide + 1;
                    int leftCol = c - possibleSide + 1;

                    boolean topBorderOK = left[topRow][c] >= possibleSide;
                    boolean leftBorderOK = up[r][leftCol] >= possibleSide;

                    if (topBorderOK && leftBorderOK) {
                        largestSide = possibleSide;
                    }

                    possibleSide--;
                }
            }
        }

        return largestSide * largestSide;
    }
}