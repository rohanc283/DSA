class Solution {
    int lowerBound(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    int upperBound(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int left = lowerBound(nums, lower - nums[i], i + 1, n - 1);
            int leftVal = left - i - 1;
            int right = upperBound(nums, upper - nums[i], i + 1, n - 1);
            int rightVal = right - i - 1;
            res += (rightVal - leftVal);
        }

        return res;
    }
}