class Solution {

    Map<Integer, Map<Character, Integer>> map;
    int M, N;
    Integer[][] dp;
    int MOD = 1_000_000_007;

    private int solve(String target, int idx, int col) {

        if (idx == N)
            return 1;

        if (col == M)
            return 0;

        if (dp[idx][col] != null)
            return dp[idx][col];

        long ans = solve(target, idx, col + 1);

        char c = target.charAt(idx);
        int freq = map.get(col).getOrDefault(c, 0);

        if (freq > 0) {
            ans += (long) freq * solve(target, idx + 1, col + 1);
        }

        ans %= MOD;

        return dp[idx][col] = (int) ans;
    }

    public int numWays(String[] words, String target) {

        map = new HashMap<>();

        M = words[0].length();
        N = target.length();

        for (int i = 0; i < M; i++) {
            map.put(i, new HashMap<>());
            for (String word : words) {
                char c = word.charAt(i);
                map.get(i).put(c, map.get(i).getOrDefault(c, 0) + 1);
            }
        }

        dp = new Integer[N][M];

        return solve(target, 0, 0);
    }
}