class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int s = 0, sum = 0;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int e = 0; e < n; e++) {
            while (set.contains(nums[e])) {
                sum -= nums[s];
                set.remove(nums[s++]);
            }
            sum += nums[e];
            set.add(nums[e]);
            res = Math.max(res, sum);
        }
        return res;
    }
}