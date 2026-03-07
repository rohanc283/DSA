class Solution {

    String[] states = {
            "RGY", "RYG", "RYR", "RGR",
            "GRY", "GYR", "GYG", "GRG",
            "YGR", "YRG", "YRY", "YGY"
    };

    int MOD = 1_000_000_007;

    Integer[][] dp;

    private int solve(int n, int prev) {

        if (n == 0)
            return 1;

        if (dp[n][prev] != null)
            return dp[n][prev];

        int ans = 0;

        String last = states[prev];

        for (int curr = 0; curr < states.length; curr++) {

            if (curr == prev)
                continue;

            String currPattern = states[curr];

            boolean conflict = false;

            for (int col = 0; col < 3; col++) {
                if (currPattern.charAt(col) == last.charAt(col)) {
                    conflict = true;
                    break;
                }
            }

            if (!conflict) {
                ans = (ans + solve(n - 1, curr)) % MOD;
            }
        }

        return dp[n][prev] = ans;
    }

    public int numOfWays(int n) {

        dp = new Integer[n + 1][states.length];

        int ans = 0;

        for (int i = 0; i < states.length; i++) {
            ans = (ans + solve(n - 1, i)) % MOD;
        }

        return ans;
    }
}