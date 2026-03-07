class Solution {
    Integer[] dp;

    public int solve(int[] arr, int i, int k) {
        int n = arr.length;
        if (i >= n)
            return 0;
        if (dp[i] != null)
            return dp[i];
        int max = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int len = 0;
        for (int j = i; j < Math.min(n, i + k); j++) {
            max = Math.max(max, arr[j]);
            len++;
            int curr = max * len + solve(arr, j + 1, k);
            ans = Math.max(ans, curr);
        }
        return dp[i] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        return solve(arr, 0, k);
    }
}