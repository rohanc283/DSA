class Solution {
    private int sol1(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);

        int res = 0;
        int currEnd = 0;
        int farthest = 0;
        int i = 0;

        while (currEnd < time) {

            while (i < clips.length && clips[i][0] <= currEnd) {
                farthest = Math.max(farthest, clips[i][1]);
                i++;
            }

            if (farthest == currEnd)
                return -1;

            res++;
            currEnd = farthest;
        }

        return res;
    }

    Integer[] dp;
    int T;

    private int solve(int[][] clips, int curr) {

        if (curr >= T)
            return 0;

        if (dp[curr] != null)
            return dp[curr];

        int ans = Integer.MAX_VALUE;

        for (int[] clip : clips) {

            if (clip[0] <= curr && clip[1] > curr) {

                int next = solve(clips, clip[1]);

                if (next != Integer.MAX_VALUE)
                    ans = Math.min(ans, 1 + next);
            }
        }

        return dp[curr] = ans;
    }

    public int sol2(int[][] clips, int time) {
        this.T = time;
        dp = new Integer[time + 1];
        int res = solve(clips, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int videoStitching(int[][] clips, int time) {
        return sol2(clips, time);
    }
}