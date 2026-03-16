class Solution {
    int m, n;

    private void DFS(int[][] image, int sr, int sc, int newColor, boolean[][] visited) {
        if (sr >= m || sr < 0 || sc < 0 || sc >= n)
            return;
        if (visited[sr][sc])
            return;
        visited[sr][sc] = true;
        int currColor = image[sr][sc];
        image[sr][sc] = newColor;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : dir) {
            int newRow = sr + d[0];
            int newCol = sc + d[1];
            if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n)
                continue;
            if (!visited[newRow][newCol] && image[newRow][newCol] == currColor) {
                DFS(image, newRow, newCol, newColor, visited);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        if (image[sr][sc] == color)
            return image;
        boolean[][] visited = new boolean[m][n];
        DFS(image, sr, sc, color, visited);
        return image;
    }
}