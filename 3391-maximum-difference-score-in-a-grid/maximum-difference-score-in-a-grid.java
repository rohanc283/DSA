class Solution {
    int M, N;
    Integer[][] dp;

    private int solve(List<List<Integer>> grid, int r, int c) {

        if (r == M - 1 && c == N - 1)
            return Integer.MIN_VALUE;

        if (dp[r][c] != null)
            return dp[r][c];

        int ans = Integer.MIN_VALUE;

        for (int j = c + 1; j < N; j++) {

            int diff = grid.get(r).get(j) - grid.get(r).get(c);

            ans = Math.max(ans, diff);

            int next = solve(grid, r, j);
            if (next != Integer.MIN_VALUE)
                ans = Math.max(ans, diff + next);
        }

        for (int i = r + 1; i < M; i++) {

            int diff = grid.get(i).get(c) - grid.get(r).get(c);

            ans = Math.max(ans, diff);

            int next = solve(grid, i, c);
            if (next != Integer.MIN_VALUE)
                ans = Math.max(ans, diff + next);
        }

        return dp[r][c] = ans;
    }

    private int sol1(List<List<Integer>> grid) {
        M = grid.size();
        N = grid.get(0).size();
        dp = new Integer[M][N];
        dp[M - 1][N - 1] = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                ans = Math.max(ans, solve(grid, r, c));
            }
        }
        return ans;
    }

    private int sol2(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] maxSuffix = new int[m][n];
        int ans = Integer.MIN_VALUE;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int val = grid.get(i).get(j);

                if (i < m - 1)
                    ans = Math.max(ans, maxSuffix[i + 1][j] - val);

                if (j < n - 1)
                    ans = Math.max(ans, maxSuffix[i][j + 1] - val);

                int down = i < m - 1 ? maxSuffix[i + 1][j] : Integer.MIN_VALUE;
                int right = j < n - 1 ? maxSuffix[i][j + 1] : Integer.MIN_VALUE;

                maxSuffix[i][j] = Math.max(val, Math.max(down, right));
            }
        }
        return ans;
    }

    public int maxScore(List<List<Integer>> grid) {
        return sol2(grid);
    }
}