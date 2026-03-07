class Solution {
    int N, G, K;
    int MOD = 1_000_000_007;
    Long[][] dp;

    private long solve(int songsAdded, int uniqueSongs) {
        if (songsAdded == G) {
            return uniqueSongs == N ? 1 : 0;
        }
        if (dp[songsAdded][uniqueSongs] != null)
            return dp[songsAdded][uniqueSongs];
        long unique = 0;
        long replay = 0;
        if (uniqueSongs < N) {
            unique = (N - uniqueSongs) * solve(songsAdded + 1, uniqueSongs + 1);
        }
        if (uniqueSongs > K) {
            replay = (uniqueSongs - K) * solve(songsAdded + 1, uniqueSongs);
        }
        return dp[songsAdded][uniqueSongs] = (unique + replay) % MOD;
    }

    public int numMusicPlaylists(int n, int goal, int k) {
        N = n;
        G = goal;
        K = k;
        dp = new Long[G + 1][N + 1];
        return (int) solve(0, 0);
    }
}