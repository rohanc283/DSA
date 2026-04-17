class Solution {
    private void rotateByK(List<Integer> temp, int k) {
        int n = temp.size();
        k = k % n;
        Collections.reverse(temp.subList(0, n - k));
        Collections.reverse(temp.subList(n - k, n));
        Collections.reverse(temp.subList(0, n));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp.add(grid[i][j]);
            }
        }
        rotateByK(temp, k);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            res.add(Arrays.stream(grid[i]).boxed().collect(Collectors.toList()));
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                res.get(i).set(j, temp.get(idx));
            }
        }
        return res;
    }
}