class Solution {
    public long findCost(int[] nums, int[] cost, long x) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += Math.abs(nums[i] - x) * cost[i];
        }
        return total;
    }

    public long minCost(int[] nums, int[] cost) {
        long l = Long.MAX_VALUE, r = Long.MIN_VALUE;
        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }

        long ans = Long.MAX_VALUE;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long c1 = findCost(nums, cost, mid);
            long c2 = findCost(nums, cost, mid + 1);

            ans = Math.min(ans, Math.min(c1, c2));
            if (c1 < c2)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return ans;
    }
}
