class Solution {

    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] nums = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i * n + j] = grid[i][j];
            }
        }

        Arrays.sort(nums);
        int target = nums[nums.length / 2];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target % x != nums[i] % x)
                return -1;
            res = res + (Math.abs(nums[i] - target) / x);
        }
        return res;
    }
}