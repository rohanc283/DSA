class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<>());
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int gap = nums[i] - nums[j];
                int len = dp.get(j).getOrDefault(gap, 0);
                dp.get(i).put(gap, 1 + len);
                ans = Math.max(ans, dp.get(i).get(gap));
            }
        }
        return ans + 1;
    }
}