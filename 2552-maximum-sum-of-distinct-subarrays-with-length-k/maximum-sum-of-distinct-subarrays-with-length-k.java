class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0, sum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            if (j >= k - 1) {
                if (map.size() == k) {
                    ans = Math.max(ans, sum);
                }
                sum -= nums[i];
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0)
                    map.remove(nums[i]);
                i++;
            }
        }
        return ans;
    }
}