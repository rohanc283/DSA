class Solution {

    Double[][] dp;
    double[] prefix;

    private double solve(int[] nums, int i, int k) {

        int n = nums.length;

        if (k == 1) {
            return (prefix[n] - prefix[i]) / (n - i);
        }

        if (dp[i][k] != null)
            return dp[i][k];

        double ans = 0;

        for (int j = i; j <= n - k; j++) {

            double sum = prefix[j + 1] - prefix[i];
            double avg = sum / (j - i + 1);

            ans = Math.max(ans, avg + solve(nums, j + 1, k - 1));
        }

        return dp[i][k] = ans;
    }

    public double largestSumOfAverages(int[] nums, int k) {

        int n = nums.length;

        dp = new Double[n][k + 1];
        prefix = new double[n + 1];

        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        return solve(nums, 0, k);
    }
}