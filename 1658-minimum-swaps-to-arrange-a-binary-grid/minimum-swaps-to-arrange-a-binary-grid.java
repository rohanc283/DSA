class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] endZeros = new int[n];
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1)
                    break;
                else {
                    zeros++;
                }
            }
            endZeros[i] = zeros;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int need = n - i - 1;
            int j = i;
            while (j < n && endZeros[j] < need)
                j++;
            if (j >= n)
                return -1;

            res += (j - i);
            while (j > i) {
                swap(endZeros, j, j - 1);
                j--;
            }
        }
        return res;
    }
}