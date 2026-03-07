class Solution {
    Integer[][] dp;
    int m, n;

    private int countSteps(int ringIdx, int currIdx, int len) {
        int distance = Math.abs(currIdx - ringIdx);
        int wrapAround = len - distance;
        return Math.min(distance, wrapAround);
    }

    private int solve(int ringIdx, int keyIdx, String ring, String key) {
        if (keyIdx >= n)
            return 0;
        int ans = Integer.MAX_VALUE;
        if (dp[ringIdx][keyIdx] != null)
            return dp[ringIdx][keyIdx];
        for (int i = 0; i < m; i++) {
            if (ring.charAt(i) == key.charAt(keyIdx)) {
                int steps = 1 + countSteps(ringIdx, i, m) + solve(i, keyIdx + 1, ring, key);
                ans = Math.min(ans, steps);
            }
        }
        return dp[ringIdx][keyIdx] = ans;
    }

    public int findRotateSteps(String ring, String key) {
        m = ring.length();
        n = key.length();
        dp = new Integer[m][n];
        return solve(0, 0, ring, key);
    }
}