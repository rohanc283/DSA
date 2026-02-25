class Solution {
    private boolean isPoss(int[] nums, int n, int p, int diff) {
        int totalPairs = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n) {
                int currDiff = nums[i + 1] - nums[i];
                if (currDiff <= diff) {
                    totalPairs++;
                    i++;
                }
            }
        }
        return totalPairs >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, h = nums[n - 1] - nums[0];
        int res = 0;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(nums, n, p, m)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}