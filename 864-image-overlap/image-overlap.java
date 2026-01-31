class Solution {
    public int countOverLap(int[][] img1, int[][] img2, int n, int rowOffset, int colOffset) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int img2I = i + rowOffset;
                int img2J = j + colOffset;
                if (img2I < 0 || img2I >= n || img2J < 0 || img2J >= n)
                    continue;
                if (img1[i][j] == 1 && img2[img2I][img2J] == 1)
                    count++;
            }
        }
        return count;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int res = 0;
        for (int rowOffset = -n + 1; rowOffset < n; rowOffset++) {
            for (int colOffset = -n + 1; colOffset < n; colOffset++) {
                res = Math.max(res, countOverLap(img1, img2, n, rowOffset, colOffset));
            }
        }
        return res;
    }
}