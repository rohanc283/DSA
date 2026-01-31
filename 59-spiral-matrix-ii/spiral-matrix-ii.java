class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int totalEle = n * n, count = 0;
        int rowStart = 0, colStart = 0;
        int totalRows = n, totalCols = n;
        while (rowStart < totalRows && colStart < totalCols &&
                count < totalEle) {

            for (int i = colStart; i < totalCols && count < totalEle; i++) {
                res[rowStart][i] = count + 1;
                count++;
            }
            rowStart++;

            for (int i = rowStart; i < totalRows && count < totalEle; i++) {
                res[i][totalCols - 1] = count + 1;
                count++;
            }
            totalCols--;

            for (int i = totalCols - 1; i >= colStart && count < totalEle; i--) {
                res[totalRows - 1][i] = count + 1;
                count++;
            }
            totalRows--;

            for (int i = totalRows - 1; i >= rowStart && count < totalEle; i--) {
                res[i][colStart] = count + 1;
                count++;
            }
            colStart++;
        }
        return res;
    }
}