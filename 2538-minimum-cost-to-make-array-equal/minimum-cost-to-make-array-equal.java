class Solution {
    public long findCost(int[] nums, int n, int[] cost, long k) {
        long currCost = 0;
        for (int i = 0; i < n; i++) {
            long diff = Math.abs(k - nums[i]);
            currCost += (diff * cost[i]);
        }
        return currCost;
    }

    public boolean alreadyEqual(int[] nums, int n) {
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[0])
                return false;
        }
        return true;
    }

    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        if (alreadyEqual(nums, n))
            return 0;
        long l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }

        long[] ans = new long[1];
        ans[0] = Long.MAX_VALUE;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long midCost1 = findCost(nums, n, cost, mid);
            long midCost2 = findCost(nums, n, cost, mid + 1);
            ans[0] = Math.min(ans[0], Math.min(midCost1, midCost2));
            if (midCost1 < midCost2) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans[0];
    }
}