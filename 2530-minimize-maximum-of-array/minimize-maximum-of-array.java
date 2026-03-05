class Solution {
    public boolean isPoss(int[] nums, int max) {
        long[] temp = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (temp[i] > max)
                return false;
            long buffer = max - temp[i];
            temp[i + 1] -= buffer;
        }
        return temp[n - 1] <= max;
    }

    public int minimizeArrayValue(int[] nums) {
        int l = 0, h = 0;
        for (int num : nums)
            h = Math.max(h, num);
        int res = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(nums, m)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}