class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums)
            total += num;
        int target = total - x;
        if (target == 0)
            return nums.length;
        int n = nums.length, s = 0, sum = 0;
        int l = -1;
        for (int e = 0; e < n; e++) {
            sum += nums[e];
            while (sum >= target && s <= e) {
                if (sum == target) {
                    l = Math.max(l, (e - s + 1));
                }
                sum -= nums[s++];
            }
        }
        if (l == -1)
            return l;
        return n - l;
    }
}