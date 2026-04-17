class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int r = 0, c = n - 1;
        while (r < m || c >= 0) {
            int i = r, j = c == -1 ? 0 : c;
            List<Integer> nums = new ArrayList<>();
            while (i < m && j < n) {
                nums.add(mat[i++][j++]);
            }
            Collections.sort(nums);
            i = r;
            j = c == -1 ? 0 : c;
            int idx = 0;
            while (i < m && j < n) {
                mat[i++][j++] = nums.get(idx++);
            }
            if (c < 0) {
                r++;
            } else {
                c--;
            }
        }
        return mat;
    }
}