class Solution {
    private boolean isPoss(int[] nums, int maxOperations, int maxPenalty) {
        long totalOps = 0;
        for (int num : nums) {
            totalOps += ((1L * num) / (1L * maxPenalty));
            if (num % maxPenalty == 0) {
                totalOps -= 1;
            }
        }
        return totalOps <= maxOperations;
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