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
                if (dp.get(j).getOrDefault(gap, 0) > 0) {
                    dp.get(i).put(gap, 1 + dp.get(j).get(gap));
                } else {
                    dp.get(i).put(gap, 1);
                }
                ans = Math.max(ans, dp.get(i).get(gap));
            }
        }
        return ans + 1;
    }
}