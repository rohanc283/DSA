class Solution {

    int M, N;
    int MOD = 1_000_000_007;
    int[][][] dp;

    public int[] solve(List<String> board, int i, int j) {

        if (i < 0 || j < 0 || board.get(i).charAt(j) == 'X')
            return new int[] { 0, Integer.MIN_VALUE };

        if (i == 0 && j == 0)
            return new int[] { 1, 0 };

        if (dp[i][j][0] != -1)
            return new int[] { dp[i][j][0], dp[i][j][1] };

        int[] up = solve(board, i - 1, j);
        int[] left = solve(board, i, j - 1);
        int[] diag = solve(board, i - 1, j - 1);

        int maxScore = Math.max(up[1], Math.max(left[1], diag[1]));

        if (maxScore == Integer.MIN_VALUE)
            return new int[] { 0, Integer.MIN_VALUE };

        int ways = 0;

        if (up[1] == maxScore)
            ways = (ways + up[0]) % MOD;
        if (left[1] == maxScore)
            ways = (ways + left[0]) % MOD;
        if (diag[1] == maxScore)
            ways = (ways + diag[0]) % MOD;

        char c = board.get(i).charAt(j);
        int digit = Character.isDigit(c) ? c - '0' : 0;

        int score = maxScore + digit;

        dp[i][j][0] = ways;
        dp[i][j][1] = score;

        return new int[] { ways, score };
    }

    private int[] sol1(List<String> board) {
        M = board.size();
        N = board.get(0).length();

        dp = new int[M][N][2];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(dp[i][j], -1);

        int[] res = solve(board, M - 1, N - 1);

        if (res[0] == 0)
            return new int[] { 0, 0 };

        return new int[] { res[1], res[0] };
    }

    private int[] solveTab(List<String> board) {
        int[] temp = new int[] { 0, Integer.MIN_VALUE };
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (i == 0 && j == 0)
                    continue;

                int[] up = i > 0 ? dp[i - 1][j] : temp;
                int[] left = j > 0 ? dp[i][j - 1] : temp;
                int[] diag = i > 0 && j > 0 ? dp[i - 1][j - 1] : temp;

                int maxScore = Math.max(up[1], Math.max(left[1], diag[1]));

                if (maxScore == Integer.MIN_VALUE)
                    continue;

                int ways = 0;

                if (up[1] == maxScore)
                    ways = (ways + up[0]) % MOD;
                if (left[1] == maxScore)
                    ways = (ways + left[0]) % MOD;
                if (diag[1] == maxScore)
                    ways = (ways + diag[0]) % MOD;

                char c = board.get(i).charAt(j);
                int digit = Character.isDigit(c) ? c - '0' : 0;

                int score = maxScore + digit;

                dp[i][j][0] = ways;
                dp[i][j][1] = score;
            }
        }
        return dp[M - 1][N - 1];
    }

    private int[] sol2(List<String> board) {
        M = board.size();
        N = board.get(0).length();

        dp = new int[M][N][2];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = 0;
                dp[i][j][1] = Integer.MIN_VALUE;
            }

        dp[0][0][0] = 1;
        dp[0][0][1] = 0;
        int[] res = solveTab(board);

        if (res[0] == 0)
            return new int[] { 0, 0 };

        return new int[] { res[1], res[0] };
    }

    public int[] pathsWithMaxScore(List<String> board) {
        return sol2(board);
    }
}