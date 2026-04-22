class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int minSwaps(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] endZeros = new int[m];
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    break;
                }
                zeros++;
            }
            endZeros[i] = zeros;
        }
        int swaps = 0;
        int i = 0;
        while (i < m) {
            int need = n - i - 1, j = i;
            while (j < m && endZeros[j] < need) {
                j++;
            }
            if (j >= n)
                return -1;
            swaps += (j - i);
            while (j > i) {
                swap(endZeros, j - 1, j--);
            }
            i++;
        }
        return swaps;
    }
}