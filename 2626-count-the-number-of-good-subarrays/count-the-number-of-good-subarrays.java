class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length, s = 0;
        long pairs = 0;
        long res = 0;
        for (int e = 0; e < n; e++) {
            pairs += freq.getOrDefault(nums[e], 0);
            freq.put(nums[e], freq.getOrDefault(nums[e], 0) + 1);
            while (pairs >= k) {
                res += (n - e);
                freq.put(nums[s], freq.get(nums[s]) - 1);
                pairs -= freq.get(nums[s]);
                s++;
            }
        }
        return res;
    }
}