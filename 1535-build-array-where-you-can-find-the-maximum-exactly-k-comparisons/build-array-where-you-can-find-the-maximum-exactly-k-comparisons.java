class Solution {
    int N, M, K;
    Integer[][][] dp;

    private int solve(int idx, int searchCost, int maxSoFar) {
        if (idx >= N)
            return searchCost == K ? 1 : 0;
        if (dp[idx][searchCost][maxSoFar + 1] != null)
            return dp[idx][searchCost][maxSoFar + 1];
        int ans = 0;
        for (int i = 1; i <= M; i++) {
            ans = (ans +
                    solve(idx + 1, i > maxSoFar ? searchCost + 1
                            : searchCost, i > maxSoFar ? i : maxSoFar))
                    % 1_000_000_007;
        }
        return dp[idx][searchCost][maxSoFar + 1] = ans;
    }

    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        dp = new Integer[N + 2][N + 2][M + 2];
        return solve(0, 0, -1);
    }
}