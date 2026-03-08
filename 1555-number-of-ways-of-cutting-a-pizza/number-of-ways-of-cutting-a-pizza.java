class Solution {
    int M;
    int N;
    int[][] apples;
    int MOD = 1_000_000_007;
    Integer[][][] dp;

    private int solve(int i, int j, int k) {
        if (k < 0)
            return 0;
        if (k == 1) {
            return apples[i][j] > 0 ? 1 : 0;
        }
        if (dp[i][j][k] != null)
            return dp[i][j][k];
        int ans = 0;
        for (int h = i + 1; h < M; h++) {
            int lowerSliceApples = apples[h][j];
            int upperSliceApples = apples[i][j] - lowerSliceApples;
            if (upperSliceApples >= 1 && lowerSliceApples >= k - 1) {
                ans = (ans + solve(h, j, k - 1)) % MOD;
            }
        }
        for (int v = j + 1; v < N; v++) {
            int rightSliceApples = apples[i][v];
            int leftSliceApples = apples[i][j] - rightSliceApples;
            if (leftSliceApples >= 1 && rightSliceApples >= k - 1) {
                ans = (ans + solve(i, v, k - 1)) % MOD;
            }
        }
        return dp[i][j][k] = ans;
    }

    public int ways(String[] pizza, int k) {
        M = pizza.length;
        N = pizza[0].length();
        apples = new int[M][N];
        dp = new Integer[M][N][k + 1];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                char c = pizza[i].charAt(j);
                int left = j + 1 < N ? apples[i][j + 1] : 0;
                int down = i + 1 < M ? apples[i + 1][j] : 0;
                int diag = i + 1 < M && j + 1 < N ? apples[i + 1][j + 1] : 0;
                apples[i][j] = left + down - diag;
                apples[i][j] += c == 'A' ? 1 : 0;
            }
        }
        return solve(0, 0, k);
    }
}