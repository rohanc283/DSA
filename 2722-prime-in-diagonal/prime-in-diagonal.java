class Solution {
    public boolean prime(int num) {
        if (num == 0 || num == 1)
            return false;
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            if (nums[i][j] > res && prime(nums[i][j])) {
                res = nums[i][j];
            }
        }
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (nums[i][j] > res && prime(nums[i][j])) {
                res = nums[i][j];
            }
        }
        return res;
    }
}