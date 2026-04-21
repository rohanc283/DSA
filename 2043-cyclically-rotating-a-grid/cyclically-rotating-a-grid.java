class Solution {
    private void rotateByK(List<Integer> temp, int k) {
        int n = temp.size();
        k = k % n;
        Collections.reverse(temp.subList(0, n - k));
        Collections.reverse(temp.subList(n - k, n));
        Collections.reverse(temp.subList(0, n));
    }

    private void populateNums(int[][] grid, List<List<Integer>> nums, int m, int n) {
        int sr = 0, sc = 0, er = m - 1, ec = n - 1;
        while (sr < er && sc < ec) {
            List<Integer> curr = new ArrayList<>();
            for (int i = sr; i <= er; i++) {
                curr.add(grid[i][sc]);
            }
            sc++;
            for (int i = sc; i <= ec; i++) {
                curr.add(grid[er][i]);
            }
            er--;
            for (int i = er; i >= sr; i--) {
                curr.add(grid[i][ec]);
            }
            ec--;
            for (int i = ec; i >= sc; i--) {
                curr.add(grid[sr][i]);
            }
            sr++;
            nums.add(curr);
        }
    }

    private void populateNumsBack(int[][] res, List<List<Integer>> nums, int m, int n) {
        int sr = 0, sc = 0, er = m - 1, ec = n - 1;
        int rIdx = 0;
        while (sr < er && sc < ec) {
            int cIdx = 0;
            for (int i = sr; i <= er; i++) {
                res[i][sc] = nums.get(rIdx).get(cIdx++);
            }
            sc++;
            for (int i = sc; i <= ec; i++) {
                res[er][i] = nums.get(rIdx).get(cIdx++);
            }
            er--;
            for (int i = er; i >= sr; i--) {
                res[i][ec] = nums.get(rIdx).get(cIdx++);
            }
            ec--;
            for (int i = ec; i >= sc; i--) {
                res[sr][i] = nums.get(rIdx).get(cIdx++);
            }
            sr++;
            rIdx++;
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> nums = new ArrayList<>();
        populateNums(grid, nums, m, n);
        for (List<Integer> curr : nums) {
            rotateByK(curr, k);
        }
        for (List<Integer> curr : nums) {
            for (Integer num : curr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        int[][] res = new int[m][n];
        populateNumsBack(res, nums, m, n);
        return res;
    }
}