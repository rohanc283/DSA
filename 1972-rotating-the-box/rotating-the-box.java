class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] res = new char[n][m];
        for (char[] row : res) {
            Arrays.fill(row, '.');
        }
        int[] freeSpace = new int[m];
        Arrays.fill(freeSpace, n - 1);

        for (int c = n - 1; c >= 0; c--) {
            for (int r = m - 1; r >= 0; r--) {
                int resColIdx = m - r - 1;
                if (boxGrid[r][c] == '*') {
                    res[c][resColIdx] = boxGrid[r][c];
                    freeSpace[resColIdx] = c - 1;
                } else if (boxGrid[r][c] == '#') {
                    int resRowIdx = freeSpace[resColIdx];
                    res[resRowIdx][resColIdx] = boxGrid[r][c];
                    freeSpace[resColIdx]--;
                }
            }
        }
        return res;
    }
}