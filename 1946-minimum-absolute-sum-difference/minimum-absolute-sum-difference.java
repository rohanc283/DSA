class Solution {
    public int findClosest(int[] nums, int tar) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == tar) {
                return m;
            } else if (nums[m] < tar) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        if (l == 0)
            return 0;
        if (l == nums.length)
            return nums.length - 1;

        if (Math.abs(nums[l] - tar) < Math.abs(nums[l - 1] - tar))
            return l;
        else
            return l - 1;
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
        }

        Arrays.sort(nums1);

        long sum = 0;
        for (long num : diff)
            sum += num;

        long res = sum;
        for (int i = 0; i < n; i++) {
            sum -= diff[i];
            int closest = findClosest(nums1, nums2[i]);
            res = Math.min(res, sum + Math.abs(nums1[closest] - nums2[i]));
            sum += diff[i];
        }

        return (int) (res % 1_000_000_007);
    }
}