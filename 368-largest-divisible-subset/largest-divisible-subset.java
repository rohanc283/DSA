class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxLen = 1, last = 0;
        for (int i = 1; i < n; i++) {
            int curr = 0, k = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] > curr) {
                    curr = dp[j];
                    k = j;
                }
            }
            dp[i] += curr;
            parent[i] = k;
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                last = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (last != -1) {
            res.add(nums[last]);
            last = parent[last];
        }
        Collections.reverse(res);
        return res;
    }
}