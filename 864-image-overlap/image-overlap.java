class Solution {

    private int overlap(int[][] a, int[][] b, int dx, int dy) {
        int n = a.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + dx;
                int y = j + dy;

                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (a[i][j] == 1 && b[x][y] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for (int dx = -n + 1; dx < n; dx++) {
            for (int dy = -n + 1; dy < n; dy++) {
                maxOverlap = Math.max(
                        maxOverlap,
                        overlap(img1, img2, dx, dy));
            }
        }

        return maxOverlap;
    }
}
