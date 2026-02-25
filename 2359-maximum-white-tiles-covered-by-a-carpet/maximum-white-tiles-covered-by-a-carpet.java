class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int n = tiles.length;
        long[] prefixTiles = new long[n];
        prefixTiles[0] = (tiles[0][1] - tiles[0][0] + 1);
        for (int i = 1; i < n; i++) {
            prefixTiles[i] = prefixTiles[i - 1] + (tiles[i][1] - tiles[i][0] + 1);
        }

        long maxCover = 0;
        for (int i = 0; i < n; i++) {
            int carpetStart = tiles[i][0];
            int carpetEnd = carpetStart + carpetLen - 1;

            int l = i, h = n - 1;
            int idx = i;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (tiles[m][0] <= carpetEnd) {
                    idx = m;
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }

            long fullCover = prefixTiles[idx] - (i > 0 ? prefixTiles[i - 1] : 0);
            if (tiles[idx][1] > carpetEnd) {
                fullCover -= (tiles[idx][1] - carpetEnd);
            }
            maxCover = Math.max(maxCover, fullCover);
        }
        return (int) (maxCover);
    }
}