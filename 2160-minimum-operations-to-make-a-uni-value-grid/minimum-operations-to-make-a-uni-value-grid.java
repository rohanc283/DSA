class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums.add(grid[i][j]);
            }
        }
        Collections.sort(nums);
        int t = m * n;
        int median = nums.get(t / 2);
        int op = 0;
        for (Integer num : nums) {
            if (num % x != median % x)
                return -1;
            op += ((Math.abs(median - num)) / x);
        }
        return op;
    }
}