class Solution {
    private boolean isPoss(int[] nums, int maxOperations, int maxPenalty) {
        long totalOps = 0;
        for (int num : nums) {
            totalOps += (num - 1) / maxPenalty;

            if (totalOps > maxOperations)
                return false; 
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, h = Integer.MIN_VALUE;
        for (int num : nums) {
            h = Math.max(h, num);
        }
        int res = 0;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPoss(nums, maxOperations, m)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}