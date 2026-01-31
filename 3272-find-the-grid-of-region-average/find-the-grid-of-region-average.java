class Solution {
    public boolean isValidRegion(int[][] image, int r, int c, int threshold) {
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 2; j++) {
                if (Math.abs(image[i][j] - image[i][j + 1]) > threshold) {
                    return false;
                }
            }
        }

        for (int j = c; j < c + 3; j++) {
            for (int i = r; i < r + 2; i++) {
                if (Math.abs(image[i][j] - image[i + 1][j]) > threshold) {
                    return false;
                }
            }
        }

        return true;
    }

    public int getAverage(int[][] image, int r, int c) {
        int sum = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                sum += image[i][j];
            }
        }
        return sum / 9;
    }

    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length, n = image[0].length;

        int[][] sum = new int[m][n];
        int[][] count = new int[m][n];

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (isValidRegion(image, i, j, threshold)) {
                    int avg = getAverage(image, i, j);

                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            sum[x][y] += avg;
                            count[x][y]++;
                        }
                    }
                }
            }
        }

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] > 0) {
                    res[i][j] = sum[i][j] / count[i][j];
                } else {
                    res[i][j] = image[i][j];
                }
            }
        }
        return res;
    }
}
