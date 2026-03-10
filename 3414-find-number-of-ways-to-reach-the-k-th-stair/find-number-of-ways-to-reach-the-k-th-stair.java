class Solution {

    Map<String, Integer> memo = new HashMap<>();
    int K;

    private int solve(int pos, int jump, int canDown) {

        if (pos > K + 1)
            return 0;

        String key = pos + "#" + jump + "#" + canDown;
        if (memo.containsKey(key))
            return memo.get(key);

        int ways = 0;

        if (pos == K)
            ways++;

        ways += solve(pos + (1 << jump), jump + 1, 1);

        if (canDown == 1 && pos > 0)
            ways += solve(pos - 1, jump, 0);

        memo.put(key, ways);
        return ways;
    }

    public int waysToReachStair(int k) {
        K = k;
        return solve(1, 0, 1);
    }
}