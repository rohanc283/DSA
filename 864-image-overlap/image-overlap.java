class Solution {
    private int findOverlapCount(int[][] img1, int[][] img2, int dx, int dy) {
        int n = img1.length;
        int overlapCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + dx, y = j + dy;
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (img1[i][j] == 1 && img1[i][j] == img2[x][y]) {
                        overlapCount++;
                    }
                }
            }
        }
        return overlapCount;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxOverlap = 0;
        int n = img1.length;
        for (int dx = -n + 1; dx < n; dx++) {
            for (int dy = -n + 1; dy < n; dy++) {
                maxOverlap = Math.max(maxOverlap, findOverlapCount(img1, img2, dx, dy));
            }
        }
        return maxOverlap;
    }
}