class Solution {

    private List<Integer> extract(int[][] grid, int sr, int er, int sc, int ec) {
        List<Integer> list = new ArrayList<>();

        for (int i = sr; i < er; i++)
            list.add(grid[i][sc]);
        for (int j = sc; j < ec; j++)
            list.add(grid[er][j]);
        for (int i = er; i > sr; i--)
            list.add(grid[i][ec]);
        for (int j = ec; j > sc; j--)
            list.add(grid[sr][j]);

        return list;
    }

    private void reverse(List<Integer> list, int l, int r) {
        while (l < r) {
            int tmp = list.get(l);
            list.set(l, list.get(r));
            list.set(r, tmp);
            l++;
            r--;
        }
    }

    private void rotateRight(List<Integer> list, int k) {
        int n = list.size();
        k %= n;
        reverse(list, 0, n - k - 1);
        reverse(list, n - k, n - 1);
        reverse(list, 0, n - 1);
    }

    private void fillBack(int[][] grid, int sr, int er, int sc, int ec, List<Integer> list) {
        int idx = 0;

        for (int i = sr; i < er; i++)
            grid[i][sc] = list.get(idx++);
        for (int j = sc; j < ec; j++)
            grid[er][j] = list.get(idx++);
        for (int i = er; i > sr; i--)
            grid[i][ec] = list.get(idx++);
        for (int j = ec; j > sc; j--)
            grid[sr][j] = list.get(idx++);
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int sr = 0, er = m - 1, sc = 0, ec = n - 1;

        while (sr < er && sc < ec) {
            List<Integer> layer = extract(grid, sr, er, sc, ec);
            rotateRight(layer, k);
            fillBack(grid, sr, er, sc, ec, layer);

            sr++;
            er--;
            sc++;
            ec--;
        }
        return grid;
    }
}
